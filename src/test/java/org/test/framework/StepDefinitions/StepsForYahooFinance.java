package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.framework.Helper.TakeSnapshot;
import org.test.framework.Utilities.LoggerUtil;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class StepsForYahooFinance {
    WebDriver driver = HooksStepDefinition.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static String input;
    public static String companyName;

    @Test
    //YF_TestCase1 - Scenario: Verify a HIGH/LOW percentage of a stock in a 5Y Range
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
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
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
        TakeSnapshot snapshot = new TakeSnapshot(driver,"YF_TC01_5Y H/L Range.png");
        LoggerUtil.info("YF_TC01 Passed - 5Y Percentage change captured successfully");

    }

    //===========================================================================================
    // YF_TestCase2 - Scenario: Verify the close price of a stock on last trading session
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
        LoggerUtil.info("YF_TC02 Passed - Retrieved close price of a stock on last trading session");
    }

    //===========================================================================================

    // YF_TestCase3 - Scenario: Validate and compare 2 stocks and get which has highest market cap
    @When("User search for a Adani Power stock on search bar")
    public void user_search_adani_power() throws InterruptedException {
        String compareStock1 = "Adani Power";

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='yf-1s1umie button']")));
        driver.findElement(By.xpath("//span[@class='yf-1s1umie button']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='card-btn yf-1yegwxr'])[1]")));
        driver.findElement(By.xpath("(//button[@class='card-btn yf-1yegwxr'])[1]")).click();

    }

    @When("User search for another stock Tata Power and hit enters")
    public void user_search_tata_power() throws InterruptedException {

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search for stock']")));
        //driver.findElement(By.xpath("//input[@aria-label='Search for stock']")).click();
        String compareStock2 = "Tata Power";

        WebElement searchInput =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Search for stock']")));
        for (int i = 0; i < compareStock2.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchInput.sendKeys(String.valueOf(compareStock2.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("Validates market cap of both and display which is higher")
    public void validate_and_compare_market_cap() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='value yf-1ykeqz6'])[1]")));
        String adaniCap = driver.findElement(By.xpath("(//span[@class='value yf-1ykeqz6'])[1]")).getText();
        System.out.println("Market Cap of AdaniPower: "+adaniCap);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='value yf-1ykeqz6'])[2]")));
        String tataCap = driver.findElement(By.xpath("(//span[@class='value yf-1ykeqz6'])[2]")).getText();
        System.out.println("Market Cap of TataPower: "+tataCap);

        String adaniValS = adaniCap.replaceAll("[a-zA-z]","");
        String tataValS = tataCap.replaceAll("[a-zA-z]","");

        if (Float.parseFloat(adaniValS) > Float.parseFloat(tataValS)) {
            System.out.println("Market Cap of Adani Power is Higher than Tata Power");
        } else
            {
                System.out.println("Market Cap of Tata Power is Higher than Adani Power");
            }

        WebElement element = driver.findElement(By.xpath("//h2[@class='yf-1pmcvpb']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        TakeSnapshot snapshot = new TakeSnapshot(driver,"YF_TC03_StockCompare.png");
        LoggerUtil.info("YF_TC03 Passed - Stocks compared successfully");
    }

    //===========================================================================================

    // YF_TestCase4 - Scenario: Verify the Founder and CEO Name of a given stock
    @When("User search for a Wipro stock on search bar")
    public void userSearchForAWiproStockOnSearchBar() throws InterruptedException {
        String companyName = "Tata Motors";
        driver.findElement(By.xpath("//input[@id='ybar-sbq']")).click();

        WebElement searchInput =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ybar-sbq']")));
        for (int i = 0; i < companyName.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchInput.sendKeys(String.valueOf(companyName.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
        searchInput.sendKeys(Keys.ENTER);
    }

    @When("user selects Profile option")
    public void user_selects_profile_option() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ellipsis yf-1e6z5da' and text()='Profile']")));
        driver.findElement(By.xpath("//span[@class='ellipsis yf-1e6z5da' and text()='Profile']")).click();
    }

    @Then("User should able to see name of Founder and CEO")
    public void user_should_see_founder_and_ceo_names() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Key Executives']")));

        WebElement element = driver.findElement(By.xpath("//h3[text()='Key Executives']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        String Role1 = driver.findElement(By.xpath("(//td[@class='yf-mj92za'])[2]")).getText();
        String Name1 = driver.findElement(By.xpath("(//td[@class='yf-mj92za'])[1]")).getText();
        System.out.println(Role1+" of "+companyName+" is: "+Name1);

        String Role2 = driver.findElement(By.xpath("(//td[@class='yf-mj92za'])[12]")).getText();
        String Name2 = driver.findElement(By.xpath("(//td[@class='yf-mj92za'])[11]")).getText();
        System.out.println(Role2+" of "+companyName+" is: "+Name2);

        TakeSnapshot snapshot = new TakeSnapshot(driver,"YF_TC04_KeyExecutives.png");
        LoggerUtil.info("YF_TC04 Passed - Chairman and CEO names are retrieved properly");
    }
}
