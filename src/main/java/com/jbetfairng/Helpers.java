package com.jbetfairng;

import com.jbetfairng.entities.MarketFilter;
import com.jbetfairng.entities.PriceProjection;
import com.jbetfairng.entities.TimeRange;
import com.jbetfairng.enums.MarketProjection;
import com.jbetfairng.enums.PriceData;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Helpers {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNullOrWhitespace(String s) {
        return s == null || isWhitespace(s);

    }

    private static boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static MarketFilter soccerMatchFilter(String country) {
        MarketFilter marketFilter = new MarketFilter();
        marketFilter.setEventTypeIds(new HashSet<>(Collections.singleton("1")));

        if (country != null)
            marketFilter.setMarketCountries(new HashSet<>(Arrays.asList(country)));

        return marketFilter;
    }

    public static Set<MarketProjection> soccerMatchProjection() {
        Set<MarketProjection> marketProjections = new HashSet<>();
        marketProjections.add(MarketProjection.COMPETITION);
        marketProjections.add(MarketProjection.RUNNER_METADATA);
        marketProjections.add(MarketProjection.MARKET_DESCRIPTION);
        marketProjections.add(MarketProjection.EVENT);
        marketProjections.add(MarketProjection.EVENT_TYPE);

        return marketProjections;
    }


    public static MarketFilter horseRaceFilter() {
        return horseRaceFilter(null);
    }


    public static MarketFilter horseRaceFilter(String country) {
        MarketFilter marketFilter = new MarketFilter();
        marketFilter.setEventTypeIds(new HashSet<>(Collections.singleton("7")));
        TimeRange timeRange = new TimeRange();
        timeRange.setFrom(DateTime.now().toDate());
        timeRange.setTo(DateTime.now().plusDays(2).toDate());
        marketFilter.setMarketStartTime(timeRange);

        if (country != null)
            marketFilter.setMarketCountries(new HashSet<>(Arrays.asList(country)));
        marketFilter.setMarketTypeCodes(new HashSet<>(Arrays.asList("WIN")));

        return marketFilter;
    }

    public static PriceProjection horseRacePriceProjection() {
        Set<PriceData> priceData = new HashSet<PriceData>();
        //get all prices from the exchange
        priceData.add(PriceData.EX_TRADED);
        priceData.add(PriceData.EX_ALL_OFFERS);

        PriceProjection priceProjection = new PriceProjection();
        priceProjection.setPriceData(priceData);
        return priceProjection;
    }

    public static Set<MarketProjection> horseRaceProjection() {
        Set<MarketProjection> marketProjections = new HashSet<MarketProjection>();
        marketProjections.add(MarketProjection.RUNNER_METADATA);
        marketProjections.add(MarketProjection.MARKET_DESCRIPTION);
        marketProjections.add(MarketProjection.EVENT);

        return marketProjections;
    }
}
