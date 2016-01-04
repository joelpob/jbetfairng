# Betfair API-NG Java Client API

A feature complete Java Betfair [API-NG] client that builds on the Betfair [sample code]. It's based on the C# [betfairng] library, however lacks the Reactive Extensions (rx) concurrency layer. 

How to use it
-------------

To login to Betfair using this library, you'll need both a) a self signed certificate (follow the process [described here]), and b) an application key [directions here]. 

```java
BetfairClient client = new BetfairClient(Exchange.AUS, "ASDF1234qwerty");
client.login("client-2048.p12", "certpass", "username", "password");
```

The "BetfairClient" class is where the magic happens. Be sure to import the Helpers class:

```java
List<MarketCatalogue> marketCatalogue = client.listMarketCatalogue(
    Helpers.horseRaceFilter("AU"),
    Helpers.horseRaceProjection(),
    MarketSort.FIRST_TO_START,
    15).getResponse();

for (MarketCatalogue c : marketCatalogue) { 
    // ... print the available markets
}

List<String> marketIds = new ArrayList<String>();
marketIds.add(marketCatalogue.get(0).getMarketId());    
List<MarketBook> marketBooks = client.listMarketBook(
    marketIds, 
    Helpers.horseRacePriceProjection(),
    null,
    null).getResponse();

for (MarketBook book : marketBooks) {
    // ... print the market book
}
```

Taking pull requests. Enjoy.

[sample code]:https://github.com/betfair/API-NG-sample-code/tree/master/java/ng
[betfairng]:https://github.com/joelpob/betfairng
[API-NG]:https://api.developer.betfair.com/services/webapps/docs/display/1smk3cen4v3lu3yomq5qye0ni/Getting+Started+with+API-NG
[described here]:https://api.developer.betfair.com/services/webapps/docs/display/1smk3cen4v3lu3yomq5qye0ni/Non-Interactive+(bot)+login
[directions here]:https://api.developer.betfair.com/services/webapps/docs/display/1smk3cen4v3lu3yomq5qye0ni/Application+Keys
