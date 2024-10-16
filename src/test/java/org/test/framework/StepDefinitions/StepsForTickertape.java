package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.framework.Helper.TakeSnapshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
//

import java.time.Duration;
import java.time.Instant;


public class StepsForTickertape {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Browser launched");
    }

    @Test
    //Scenario: User searches Tickertape on Google and navigates to the site
    @Given("User is on google homepage")
    public void user_is_on_google_homepage() {
        System.out.println("This is Step 1");
        driver.navigate().to("http://www.google.com/");
        driver.manage().window().maximize();
        System.out.println("Google Started at \t" + Instant.now());
    }

    @When("User enters Tickertape in search bar")
    public void user_enters_tickertape_in_search_bar() {
        System.out.println("This is Step 2");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("tickertape.in");
    }

    @When("Clicks enter")
    public void clicks_enter() {
        System.out.println("This is Step 3");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div/div[4]/center/input[1]")).sendKeys(Keys.ENTER);
        System.out.println("Searched Tickertape at \t" + Instant.now());
    }

    @Then("User clicks on the link of tickertape site")
    public void user_clicks_on_the_link_of_tickertape_site() throws InterruptedException {
        System.out.println("This is Step 4");
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
        Thread.sleep(5000);
    }

    @Then("User is able to enter the site and verify title")
    public void user_is_able_to_enter_the_site_and_verify_title() {
        System.out.println("This is Step 5");
        System.out.println("Opened Tickertape Site at \t" + Instant.now());
        // Get the title of the page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Stock Analysis & Best Financial Tools for Indian Stock Market Evaluation | Tickertape";
        //content="Stock Analysis & Best Financial Tools for Indian Stock Market Evaluation | Tickertape"
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected value!");
        System.out.println(actualTitle);
    }

    //========================================================================================================//

    @Test
    //Scenario: User searches stock on tickertape site
    @Given("URL to the Tickertape site")
    public void url_to_the_tickertape_site() {
        System.out.println("TC2_This is Step 1");
        driver.navigate().to("https://www.tickertape.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("Tickertape Started at \t" + Instant.now());
    }

    @When("User search a stock on Search bar")
    public void user_search_a_stock_on_search_bar() throws InterruptedException {
        System.out.println("TC2_This is Step 2");
        ////input[@id="search-stock-input"]
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String input = "ITC";
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div/div[1]/div[2]/div/div[1]/input"));
        //searchBar.sendKeys("ITC",Keys.ENTER);
      //  new Actions(driver).sendKeys(searchBar,Keys.chord("ITC")).perform();
        for (int i = 0; i < input.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchBar.sendKeys(String.valueOf(input.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(3000);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement stockSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='stock-suggestion-ITC Ltd']/div[1]")));
        stockSuggestion.click();
        Thread.sleep(3000);
    }

    @Then("User should see the LTP of the stock")
    public void user_should_see_the_ltp_of_the_stock() throws InterruptedException {
        System.out.println("TC2_This is Step 3");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        String StockPrice = driver.findElement(By.xpath("//span[contains(@class,'current-price')]")).getText();
        String StockPer = driver.findElement(By.xpath("//span[contains(@class,'percentage-value')]")).getText();
        String StockNm = driver.findElement(By.xpath("//h1[contains(@class,'security-name')]")).getText();

        System.out.println("Text inside the element Price: " + StockPrice);
        System.out.println("Text inside the element Percentage: " + StockPer);
        System.out.println("Text inside the element StockName: " + StockNm);


        //  float LTPofITC = Float.valueOf(ITCPrice.trim());  // Remove any leading/trailing spaces with .trim()
        // System.out.println("Text inside the element: " + LTPofITC);
    }


    //========================================================================================================//

    //Scenario: Check the Market mood on MMI (Market Mood Index) screen
    @Test

    @Given("URL to the Tickertape site to check MMI")
    public void url_to_the_tickertape_site_to_check_mmi() {
        System.out.println("TC3_This is Step 1");
        driver.navigate().to("https://www.tickertape.in/");
        driver.manage().window().maximize();
        System.out.println("Tickertape Started at \t" + Instant.now());
    }

    @When("User clicks on the MMI link on homepage")
    public void user_clicks_on_the_mmi_link_on_homepage() {
        driver.findElement(By.xpath("//a[@href='/market-mood-index?ref=homepage_mmi_section']")).click();
    }

    @When("User navigates to MMI page")
    public void user_navigates_to_mmi_page() {
        // driver.switchTo().window(String.valueOf(1));
        String mainWindow = driver.getWindowHandle();  // Save the current window handle
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfWindowsToBe(2));

        // Loop through the window handles and switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!mainWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

    }

    @Then("User should know the mood of market by seeing the meter")
    public void user_should_know_the_mood_of_market_by_seeing_the_meter() {
        System.out.println("Title of the new tab: " + driver.getTitle());
        String Index = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div[1]/div/div[2]/span")).getText();
        // Convert the string to a float
        float marketMood = Float.valueOf(Index.trim());  // Remove any leading/trailing spaces with .trim()

        System.out.println("Market Meter shows the value: " + marketMood);
        TakeSnapshot snapshot = new TakeSnapshot(driver, "Market_Zone");

        if (marketMood < 30) {
            System.out.println("THE MARKET IS IN EXTREME FEAR ZONE");
        } else if (marketMood >= 30 && marketMood <= 50) {
            System.out.println("THE MARKET IS IN FEAR ZONE");
        } else if (marketMood >= 51 && marketMood <= 70) {
            System.out.println("THE MARKET IS IN GREED ZONE");
        } else if (marketMood > 70) {
            System.out.println("THE MARKET IS IN EXTREME GREED ZONE");
        } else {
            System.out.println("Market mood value is out of expected range!");
        }

    }

    //==============================================================================================

    // Scenario: FIND TOP 5 GAINERS

    @When("User is on the Dashboard or Homepage")
    public void userIsOnTheDashboardOrHomepage() {

    }

    @Then("top 5 gainers stock names should be displayed")
    public void display_top_5_gainers() {
        // Implement retrieval and display of top 5 gainers' stock names
    }


    // Scenario: FIND TOP 5 LOSERS
    @And("clicks on losers button on Today's stocks section")
    public void clicksOnLosersButtonOnTodaySStocksSection() {
    }

    @Then("top 5 losers stocks should be displayed")
    public void display_top_5_losers() {
        // Implement retrieval and display of top 5 losers' stock names
    }


    // Scenario: OPEN SITE, CLICK SEE ALL, GET NIFTY IT LTP
    @When("User clicks on See All button on the Index section Then choose the Sectoral button")
    public void userClicksOnSeeAllButtonOnTheIndexSectionThenChooseTheSectoralButton() {

    }

    @Then("Nifty IT price should be printed")
    public void print_nifty_it_price() {
        // Implement retrieval and print of Nifty IT price (LTP - Last Traded Price)
    }


    // Scenario: FILTER THE TOP 5 SMALL CAP STOCKS IN TERMS OF MARKET CAP
    @When("Clicks on Screener menu and Clicks on Start Screening Option And Navigates to the Screener page")
    public void clicksOnScreenerMenuAndClicksOnStartScreeningOptionAndNavigatesToTheScreenerPage() {

    }

    @When("Selects Small Cap option from the left pane")
    public void user_selects_small_cap_option() {
        // Implement selection of Small Cap option from the filter pane
    }

    @Then("Pick first {int} small stocks and Print them with Market cap")
    public void pickFirstSmallStocksAndPrintThemWithMarketCap(int arg0) {
    }


    // Scenario: FILTER THE TOP 5 MID CAP STOCKS IN TERMS OF MARKET CAP
    @When("Selects Mid Cap option from the left pane")
    public void user_selects_mid_cap_option() {
        // Implement selection of Mid Cap option from the filter pane
    }

    @Then("Pick first {int} mid stocks and Print them with Market cap")
    public void pickFirstMidStocksAndPrintThemWithMarketCap(int arg0) {
    }


    // Scenario: FILTER THE TOP 5 LARGE CAP STOCKS IN TERMS OF MARKET CAP
    @When("Selects Large Cap option from the left pane")
    public void user_selects_large_cap_option() {
        // Implement selection of Large Cap option from the filter pane
    }


    @Then("Pick first {int} large stocks and Print them with Market cap")
    public void pickFirstLargeStocksAndPrintThemWithMarketCap(int arg0) {

    }

    @After
    public void browserClose() {
        //driver.close();
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }


}

