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

Or for soccer 
```java
 List<MarketCatalogue> marketCatalogueList = client.listMarketCatalogue(
                Helpers.soccerMatchFilter(null),
                Helpers.soccerMatchProjection(),
                MarketSort.FIRST_TO_START, 20).getResponse();

        for (MarketCatalogue marketCatalogue : marketCatalogueList) {
            printMarketCatalogue(marketCatalogue);
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
```
[sample code]:https://github.com/betfair/API-NG-sample-code/tree/master/java/ng
[betfairng]:https://github.com/joelpob/betfairng
[API-NG]:http://docs.developer.betfair.com/docs/display/1smk3cen4v3lu3yomq5qye0ni/Getting+Started+with+API-NG
[described here]:http://docs.developer.betfair.com/docs/display/1smk3cen4v3lu3yomq5qye0ni/Non-Interactive+%28bot%29+login
[directions here]:http://docs.developer.betfair.com/docs/display/1smk3cen4v3lu3yomq5qye0ni/Application+Keys
