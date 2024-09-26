Feature: Tickertape Site Automation

  @TestCase1 @Smoke
  Scenario: User searches Tickertape on Google and navigates to the site
    Given User is on google homepage
    When User enters Tickertape in search bar
    And Clicks enter
    Then User clicks on the link of tickertape site
    And User is able to enter the site and verify title

  @TestCase2 @Smoke
  Scenario: User searches stock on tickertape site
    Given URL to the Tickertape site
    When User search a stock on Search bar
    Then User should see the LTP of the stock

  @TestCase3
  Scenario: Check the Market mood on MMI (Market Mood Index) screen
    Given URL to the Tickertape site to check MMI
    When User clicks on the MMI link on homepage
    And User navigates to MMI page
    Then User should know the mood of market by seeing the meter

