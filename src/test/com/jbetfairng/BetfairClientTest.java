package com.jbetfairng;

import com.jbetfairng.config.AppConfig;
import com.jbetfairng.entities.*;
import com.jbetfairng.enums.*;
import com.jbetfairng.exceptions.LoginException;
import com.jbetfairng.util.Helpers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by catalin on 4/19/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BetfairClientTest {
    @Autowired
    AppConfig appConfig;

    private BetfairClient client;
    private Set<String> marketTypeCodes;

    @Before
    public void setUp() {
        client = new BetfairClient(Exchange.RO, appConfig.getAppKey());
        try {
            client.login(appConfig.getCertificateFile(), appConfig.getCertificatePassword(), appConfig.getUserName(), appConfig.getPassword());
        } catch (LoginException exc) {
            System.out.println(exc);
        }

        marketTypeCodes = new HashSet<>();
        marketTypeCodes.add(MarketType.MATCH_BET.toString());
        marketTypeCodes.add(MarketType.MATCH_ODDS_AND_BTTS.toString());
        marketTypeCodes.add(MarketType.MATCH_ODDS.toString());
    }

    public void tearDown() {

    }

    @Test
    public void listMarketCatalogue() {

        List<MarketCatalogue> marketCatalogueList = client.listMarketCatalogue(
                Helpers.soccerMatchFilter(null, null, marketTypeCodes),
                Helpers.soccerMatchProjection(),
                MarketSort.FIRST_TO_START, 40).getResponse();

        for (MarketCatalogue marketCatalogue : marketCatalogueList) {
            System.out.println("Market Name: " + marketCatalogue.getMarketName() + "; Id: " + marketCatalogue.getMarketId()
                    + ";Competition: " + marketCatalogue.getCompetition() + "; Time: " + marketCatalogue.getDescription().getMarketTime() + "\n");

            List<RunnerCatalog> runners = marketCatalogue.getRunners();
            if (runners != null) {
                for (RunnerCatalog rCat : runners) {
                    System.out.println("Runner Name: " + rCat.getRunnerName() + "; Selection Id: " + rCat.getSelectionId() + "\n");
                }
            }

        }
    }

    @Test
    public void placeBets() {

        List<MarketCatalogue> marketCatalogueList = client.listMarketCatalogue(
                Helpers.soccerMatchFilter(null, null, marketTypeCodes),
                Helpers.soccerMatchProjection(),
                MarketSort.FIRST_TO_START, 5).getResponse();

        for (MarketCatalogue marketCatalogue : marketCatalogueList) {
            System.out.println("Market Name: " + marketCatalogue.getMarketName() + "; Id: " + marketCatalogue.getMarketId()
                    + ";Competition: " + marketCatalogue.getCompetition() + "; Time: " + marketCatalogue.getDescription().getMarketTime() + "\n");

            List<RunnerCatalog> runners = marketCatalogue.getRunners();
            if (runners != null) {
                for (RunnerCatalog rCat : runners) {
                    System.out.println("Runner Name: " + rCat.getRunnerName() + "; Selection Id: " + rCat.getSelectionId() + "\n");
                }
            }
            // this call is only to see which are available bets for an event
            List<MarketBook> marketBookList = client.listMarketBook(Collections.singletonList(marketCatalogue.getMarketId()), Helpers.soccerPriceProjection(),
                    null, null).getResponse();
            for (MarketBook marketBook : marketBookList) {
                System.out.println(marketBook.getRunners());

                PlaceInstruction placeInstruction = new PlaceInstruction();
                placeInstruction.setSelectionId(marketBook.getRunners().get(0).getSelectionId());
                placeInstruction.setSide(Side.LAY);
                placeInstruction.setHandicap(0);
                placeInstruction.setOrderType(OrderType.LIMIT);

                LimitOrder limitOrder = new LimitOrder();
                limitOrder.setSize(2);
                limitOrder.setPrice(Helpers.getMaxBetIncrement(marketBook.getRunners().get(0).getLastPriceTraded()));
                limitOrder.setPersistenceType(PersistenceType.LAPSE);
                placeInstruction.setLimitOrder(limitOrder);

                PlaceExecutionReport placeExecutionReport = client.placeOrders(marketCatalogue.getMarketId(), Collections.singletonList(placeInstruction), null, marketBook.getVersion()).getResponse();
                if (placeExecutionReport != null) {
                    if (ExecutionReportStatus.FAILURE.equals(placeExecutionReport.getStatus())) {
                        System.out.println(placeExecutionReport.getErrorCode() + " - " + placeExecutionReport.getInstructionReports().get(0).getErrorCode());
                    } else {
                        System.out.println(placeExecutionReport.getStatus() + " - " + placeExecutionReport.getInstructionReports().get(0).getStatus());
                    }
                }
            }
        }

    }

}