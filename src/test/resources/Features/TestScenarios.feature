Feature: Google Search and Tickertape navigation

  Scenario: User searches Tickertape on Google and navigates to the site
    Given User is on google homepage
    When User enters Tickertape in search bar
    And Clicks enter
    Then User clicks on the link of tickertape site
    And User is able to enter the site and verify title
