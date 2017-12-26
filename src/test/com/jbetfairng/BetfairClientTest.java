package com.jbetfairng;

import com.jbetfairng.entities.*;
import com.jbetfairng.enums.*;
import com.jbetfairng.exceptions.LoginException;
import com.jbetfairng.util.Helpers;
import org.junit.Test;

import java.util.*;


/**
 * Created by catalin on 4/19/2017.
 */
public class BetfairClientTest {


    @Test
    public void listMarketCatalogue() throws Exception {

        BetfairClient client = new BetfairClient(Exchange.RO, "app_key");
        try {
            client.login("certificate_location", "certificate_password", "username", "parola");
        } catch (LoginException exc) {
            System.out.println(exc);
        }

        Set<String> marketTypeCodes = new HashSet<>();
        marketTypeCodes.add(MarketType.MATCH_BET.toString());
        marketTypeCodes.add(MarketType.MATCH_ODDS_AND_BTTS.toString());
        marketTypeCodes.add(MarketType.MATCH_ODDS.toString());


        List<MarketCatalogue> marketCatalogueList = client.listMarketCatalogue(
                Helpers.soccerMatchFilter(null, null, marketTypeCodes),
                Helpers.soccerMatchProjection(),
                MarketSort.FIRST_TO_START, 40).getResponse();

        for (MarketCatalogue marketCatalogue : marketCatalogueList) {
            List<MarketBook> marketBookList = client.listMarketBook(Collections.singletonList(marketCatalogue.getMarketId()), Helpers.soccerPriceProjection(),
                    null, null).getResponse();

            printMarketCatalogue(marketCatalogue);
        }

    }


    private void printMarketCatalogue(MarketCatalogue mk) {
        System.out.println("Market Name: " + mk.getMarketName() + "; Id: " + mk.getMarketId()
                + ";Competition: " + mk.getCompetition() + "; Time: " + mk.getDescription().getMarketTime() + "\n");

        List<RunnerCatalog> runners = mk.getRunners();
        if (runners != null) {
            for (RunnerCatalog rCat : runners) {
                System.out.println("Runner Name: " + rCat.getRunnerName() + "; Selection Id: " + rCat.getSelectionId() + "\n");
            }
        }
    }

}