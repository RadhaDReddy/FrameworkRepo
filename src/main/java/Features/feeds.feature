Feature: Load feed feature
 
Scenario Outline: Load feed Test Scenario

Given user is already on Home page
When user clicks on "<feedlink>" feed
Then "<feedtitle>" feed is loaded
Then changes the version
Then the version for "<feedname>" should get updated

Examples:

| feedlink | feedtitle | feedname |
| GTFS Import (Jun 24, 2019) | GTFS Import (Jun 24, 2019) | GTFS Import (Jun 24, 2019) |