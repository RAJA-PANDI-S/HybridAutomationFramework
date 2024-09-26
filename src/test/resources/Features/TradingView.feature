Feature: Trading View Test Automation Scenarios

  @TV_TestCase1
  Scenario: Verify that User login to the Trading view site and Validate successful login
    Given URL for the Trading view Site and Selects sign option
    When User enters username and password
    And Clicks on submit button for login
    Then User able to view Dashboard and Ensure successful login