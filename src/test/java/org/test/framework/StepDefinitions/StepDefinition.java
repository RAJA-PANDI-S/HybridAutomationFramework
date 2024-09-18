package org.test.framework.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    @Given("User is on google homepage")
    public void user_is_on_google_homepage() {
        System.out.println("This is Step 1");
    }

    @When("User enters Tickertape in search bar")
    public void user_enters_tickertape_in_search_bar() {
        System.out.println("This is Step 2");

    }

    @When("Clicks enter")
    public void clicks_enter() {
        System.out.println("This is Step 3");

    }

    @Then("User clicks on the link of tickertape site")
    public void user_clicks_on_the_link_of_tickertape_site() {
        System.out.println("This is Step 4");
    }

    @Then("User is able to enter the site and verify title")
    public void user_is_able_to_enter_the_site_and_verify_title() {
        System.out.println("This is Step 5");
    }
}
