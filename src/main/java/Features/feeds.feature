Feature: Load feed feature
 
Scenario Outline: Load feed Test Scenario

Given user is already on Home page
When user clicks on "<feedlink>" feed
Then "<feedtitle>" feed is loaded
Then enter new version

Examples:

| feedlink | feedtitle |
| GTFS Import (Jun 24, 2019) | GTFS Import (Jun 24, 2019) |