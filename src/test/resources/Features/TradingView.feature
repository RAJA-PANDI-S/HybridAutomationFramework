Feature: Trading View Test Automation Scenarios

  @TV_TestCase1 @TV_Regression
  Scenario: Verify that User login to the Trading view site and Validate successful login
    Given URL to the TradingView site
    When User Clicks on Profile icon and Chooses Sign in option
    And Selects Email option to login
    Then Login page appears where User enters Username and Password
    And User clicks sign in button and able to login successfully


