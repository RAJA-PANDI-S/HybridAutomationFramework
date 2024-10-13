Feature: Trading View Test Automation Scenarios

  @TV_TestCase1 @TV_Regression
  Scenario: Verify that User login to the Trading view site and Validate successful login
    Given URL to the TradingView site
    When User Clicks on Profile icon and Chooses Sign in option
    And Selects Email option to login
    Then Login page appears where User enters Username and Password
    And User clicks sign in button and able to login successfully

  @TV_TestCase2 @TV_Regression
  Scenario: Verify that negative scenario for login functionality
    Given URL to the TradingView site
    When User Clicks on Profile icon and Chooses Sign in option
    And Selects Email option to login
    Then Login page appears where User enters invalid Username or Password
    And login should failed and info message should displayed as 'Invalid username or password'

  @TV_TestCase3 @TV_Regression
  Scenario: Verify that User login to the Trading view site and Validate successful login
    Given URL to the TradingView site
    When User Enters NIFTY in a search box
    And user hit Enter and A Chart opens
    Then User clicks on stock screener option at the bottom
    And go to filter and choses Health services in sector
    And close the current popup now click export csv option to download the data