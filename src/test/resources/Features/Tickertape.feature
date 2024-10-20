Feature: Tickertape Site Automation

  @TT_TestCase1 @TT_Regression @Smoke
  Scenario: User searches Tickertape on Google and navigates to the site
    Given User is on google homepage
    When User enters Tickertape in search bar
    And Clicks enter
    Then User clicks on the link of tickertape site
    And User is able to enter the site and verify title

  @TT_TestCase2 @TT_Regression @Smoke
  Scenario: User searches stock on tickertape site
    Given URL to the Tickertape site
    When User search a stock on Search bar
    Then User should see the LTP of the stock

  @TT_TestCase3 @TT_Regression
  Scenario: Check the Market mood on MMI (Market Mood Index) screen
    Given URL to the Tickertape site to check MMI
    When User clicks on the MMI link on homepage
    And User navigates to MMI page
    Then User should know the mood of market by seeing the meter

  @TT_TestCase4 @TT_Regression
  Scenario: FIND TOP 5 GAINERS
    Given URL to the Tickertape site
    When User is on the Dashboard or Homepage
    Then top 5 gainers stock names should be displayed

  @TT_TestCase5 @TT_Regression
  Scenario: FIND TOP 5 LOSERS
    Given URL to the Tickertape site
    When clicks on losers button on Today's stocks section
    Then top 5 losers stocks should be displayed

  @TT_TestCase6 @TT_Regression
  Scenario: OPEN SITE, CLICK SEE ALL, GET NIFTY IT LTP
    Given URL to the Tickertape site
    When User clicks on See All button on the Index section Then choose the Sectoral button
    And Nifty IT price should be printed

  @TT_TestCase7 @TT_Regression
  Scenario: FILTER THE TOP 5 SMALL CAP STOCKS IN TERMS OF MARKET CAP
    Given URL to the Tickertape site
    When Clicks on Screener menu and Clicks on Start Screening Option And Navigates to the Screener page
    And Selects Small Cap option from the left pane
    Then Pick first 5 small stocks and Print them with Market cap

  @TT_TestCase8 @TT_Regression
  Scenario: FILTER THE TOP 5 MID CAP STOCKS IN TERMS OF MARKET CAP
    Given URL to the Tickertape site
    When Clicks on Screener menu and Clicks on Start Screening Option And Navigates to the Screener page
    And Selects Mid Cap option from the left pane
    Then Pick first 5 mid stocks and Print them with Market cap

  @TT_TestCase9 @TT_Regression
  Scenario: FILTER THE TOP 5 LARGE CAP STOCKS IN TERMS OF MARKET CAP
    Given URL to the Tickertape site
    When Clicks on Screener menu and Clicks on Start Screening Option And Navigates to the Screener page
    And Selects Large Cap option from the left pane
    Then Pick first 5 large stocks and Print them with Market cap







