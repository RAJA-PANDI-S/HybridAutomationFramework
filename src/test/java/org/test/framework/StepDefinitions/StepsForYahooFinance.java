package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.framework.Helper.TakeSnapshot;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class StepsForYahooFinance {
    WebDriver driver = HooksStepDefinition.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static String input;

    @Test
    // Scenario: Verify a HIGH/LOW percentage of a stock in a 5Y Range
    @Given("URL to the Yahoo Finance site")
    public void open_yahoo_finance_site() {
        System.out.println("This is Step 1_YF");
        driver.navigate().to("https://finance.yahoo.com/");
        driver.manage().window().maximize();
        System.out.println("Site opened at \t" + Instant.now());
    }

    @When("User search for a stock on search bar")
    public void user_search_for_a_stock() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='ybar-sbq']")).click();

        input = "NIFTY";
        WebElement searchInput =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ybar-sbq']")));
        for (int i = 0; i < input.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchInput.sendKeys(String.valueOf(input.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(2000);
        }
        Thread.sleep(3000);
        searchInput.sendKeys(Keys.ENTER);

    }

    @When("Chooses 5Y range in the graph")
    public void user_selects_5Y_range() {
        //h1[@class='yf-xxbei9']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='yf-xxbei9']")));
        driver.findElement(By.xpath("//span[@class='container tw-px-3 yf-7dju6j' and text()='5Y']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tooltip al-bottom positive plain yf-7dju6j displayed']")));
        TakeSnapshot snapshot = new TakeSnapshot(driver, "YF_TC01_Nifty50 5Y Range");
    }

    @Then("a tooltip should display with percentage value")
    public void tooltip_should_display_percentage_value() {
        WebElement Percentage = driver.findElement(By.xpath("//div[@class='tooltip al-bottom positive plain yf-7dju6j displayed']"));
        String change = Percentage.getText();
        System.out.println("5Y Price change of NIFTY50 Index is: "+change);
    }

    //===========================================================================================
    // Scenario: Verify the close price of a stock on last trading session
    @When("Chooses Historical Data option")
    public void user_selects_historical_data_option() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ellipsis yf-1e6z5da' and text()='Historical Data']")));
        driver.findElement(By.xpath("//span[@class='ellipsis yf-1e6z5da' and text()='Historical Data']")).click();

    }

    @Then("User should see the close price of a stock on last trading session")
    public void user_should_see_close_price_on_date() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='yf-h2urb6'])[5]")));
        String closeDate = driver.findElement(By.xpath("(//td[@class='yf-h2urb6'])[1]")).getText();
        String closePrice = driver.findElement(By.xpath("(//td[@class='yf-h2urb6'])[5]")).getText();
        System.out.println("The Close price of "+input+" on the last trading session "+closeDate+ " is --> "+closePrice);
    }

    //===========================================================================================

    // Scenario: Validate and compare 2 stocks and get which has highest market cap
    @When("User search for a Adani Power stock on search bar")
    public void user_search_adani_power() throws InterruptedException {
        String compareStock1 = "Adani Power";
        String compareStock2 = "Tata Power";

        WebElement searchInput =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ybar-sbq']")));
        for (int i = 0; i < compareStock1.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchInput.sendKeys(String.valueOf(compareStock1.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(1000);
        }
        Thread.sleep(3000);
        searchInput.sendKeys(Keys.ENTER);
    }

    @When("Clicks compare option and clicks on Add")
    public void user_clicks_compare_and_add() {
//span[@class='yf-1s1umie button']
        (//button[@class='card-btn yf-1yegwxr'])[1]
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
