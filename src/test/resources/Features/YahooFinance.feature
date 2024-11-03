Feature: Yahoo Finance Test Automation Scenarios

  @YF_TestCase1 @YF_Regression
  Scenario: Verify a HIGH/LOW percentage of a stock in a 5Y Range
  Given URL to the Yahoo Finance site
  When User search for a stock on search bar
  And Chooses 5Y range in the graph
  Then a tooltip should display with percentage value

  @YF_TestCase2 @YF_Regression
  Scenario: Verify the close price of a stock on last trading session
  Given URL to the Yahoo Finance site
  When User search for a stock on search bar
  And Chooses Historical Data option
  Then User should see the close price of a stock on last trading session

  @YF_TestCase3 @YF_Regression
  Scenario: Validate and compare 2 stocks and get which has highest market cap
  Given URL to the Yahoo Finance site
  When User search for a Adani Power stock on search bar
  And Clicks compare option and clicks on Add
  Then User search for another stock Tata Power and hit enters
  And Validates market cap of both and display which is higher

  @YF_TestCase4 @YF_Regression
  Scenario: Verify the Founder and CEO Name of a given stock
  Given URL to the Yahoo Finance site
  When User search for a Wipro stock on search bar
  And user selects Profile option
  Then User should able to see name of Founder and CEO

 #@YF_TestCase5 @YF_Regression
 #Scenario: Verify the Recently viewed section is working as expected on dashboard
  #Given URL to the Yahoo Finance site
  #When User search for 3 stocks stock on search bar one by one
  #And goes to the dashboard
  #Then Verifies recently viewed section and Confirms those 3 stocks are listed
