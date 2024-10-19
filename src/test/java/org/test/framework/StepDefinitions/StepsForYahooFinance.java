package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Instant;

public class StepsForYahooFinance {
    WebDriver driver = HooksStepDefinition.driver;
    WebDriverWait wait;

    @Test
    // Scenario: Verify a HIGH/LOW percentage of a stock in a 5Y Range
    @Given("URL to the Yahoo Finance site")
    public void open_yahoo_finance_site() {
        // Implement navigation to Yahoo Finance
    }

    @When("User search for a stock on search bar")
    public void user_search_for_a_stock() {
        // Implement stock search in the search bar
    }

    @When("Chooses 5Y range in the graph")
    public void user_selects_5Y_range() {
        // Implement selection of the 5Y range in the graph
    }

    @Then("a tooltip should display with percentage value")
    public void tooltip_should_display_percentage_value() {
        // Implement verification of the tooltip showing percentage value
    }

    //===========================================================================================
    // Scenario: Verify the close price of a stock on OCT 15,2024
    @When("Chooses Historical Data option")
    public void user_selects_historical_data_option() {
        // Implement selection of the Historical Data option
    }

    @Then("User should see the close price of a stock on Oct 15, 2024")
    public void user_should_see_close_price_on_date() {
        // Implement verification of close price for the specific date
    }

    //===========================================================================================

    // Scenario: Validate and compare 2 stocks and get which has highest market cap
    @When("User search for a Adani Power stock on search bar")
    public void user_search_adani_power() {
        // Implement search for Adani Power stock
    }

    @When("Clicks compare option and clicks on Add")
    public void user_clicks_compare_and_add() {
        // Implement the action of clicking Compare and Add options
    }

    @When("User search for another stock Tata Power and hit enters")
    public void user_search_tata_power() {
        // Implement search for Tata Power stock
    }

    @Then("Validates market cap of both and display which is higher")
    public void validate_and_compare_market_cap() {
        // Implement validation and comparison of the market cap for both stocks
    }

    //===========================================================================================

    // Scenario: Verify the Founder and CEO Name of a given stock
    @When("User search for a Wipro stock on search bar")
    public void userSearchForAWiproStockOnSearchBar() {

    }

    @When("user selects Profile option")
    public void user_selects_profile_option() {
        // Implement selection of Profile option for the stock
    }

    @Then("User should able to see name of Founder and CEO")
    public void user_should_see_founder_and_ceo_names() {
        // Implement verification of Founder and CEO names
    }

    //===========================================================================================

    // Scenario: Verify the Recently viewed section is working as expected on dashboard
    @When("User search for 3 stocks stock on search bar one by one")
    public void user_search_for_three_stocks() {
        // Implement search for 3 different stocks one by one
    }

    @When("goes to the dashboard")
    public void user_goes_to_dashboard() {
        // Implement navigation to the dashboard
    }

    @Then("Verifies recently viewed section and Confirms those 3 stocks are listed")
    public void verify_recently_viewed_section() {
        // Implement verification of the Recently Viewed section on the dashboard
    }

    //===========================================================================================

}
