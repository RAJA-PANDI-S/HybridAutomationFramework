package org.test.framework.StepDefinitions;

import org.openqa.selenium.*;
import org.test.framework.Utilities.ExtentUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.framework.Helper.TakeSnapshot;
import org.test.framework.Utilities.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
//

import java.time.Duration;
import java.time.Instant;

import static org.test.framework.Utilities.ExtentUtil.test;


public class StepsForTickertape {

    WebDriver driver = HooksStepDefinition.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    ExtentUtil extentUtil = new ExtentUtil();


    @Test
    //TT_TestCase1 - Scenario: User searches Tickertape on Google and navigates to the site
    @Given("User is on google homepage")
    public void user_is_on_google_homepage() {
        System.out.println("This is Step 1");
        driver.navigate().to("http://www.google.com/");
        driver.manage().window().maximize();
        System.out.println("Google Started at \t{}" + Instant.now());
        extentUtil.extentCreateTest("TC01_Enter Google Chrome");
        test.pass("Step 1 Passed");

    }

    @When("User enters Tickertape in search bar")
    public void user_enters_tickertape_in_search_bar() {
        System.out.println("This is Step 2");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("tickertape.in");
        extentUtil.extentCreateTest("TC01_Search for Tickertape.in");
        test.pass("Step 2 Passed");
    }

    @When("Clicks enter")
    public void clicks_enter() {
        System.out.println("This is Step 3");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div/div[4]/center/input[1]")).sendKeys(Keys.ENTER);
        System.out.println("Searched Tickertape at \t{}" + Instant.now());
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

        LoggerUtil.info("TT_TC01 Passed - Title matches successfully");
    }

    //========================================================================================================//

    @Test
    //TT_TestCase2 - Scenario: User searches stock on tickertape site
    @Given("URL to the Tickertape site")
    public void url_to_the_tickertape_site() {
        System.out.println("TC2_This is Step 1");
        driver.navigate().to("https://www.tickertape.in/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("Tickertape Started at \t" + Instant.now());
        extentUtil.extentCreateTest("TC02_Verify Stock Data");
        test.pass("TC02_Step 1 Passed");
    }

    @When("User search a stock on Search bar")
    public void user_search_a_stock_on_search_bar() throws InterruptedException {
        System.out.println("TC2_This is Step 2");
        ////input[@id="search-stock-input"]
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String input = "ITC";
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div/div[1]/div[2]/div/div[1]/input"));

        for (int i = 0; i < input.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchBar.sendKeys(String.valueOf(input.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(2000);
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

        LoggerUtil.info("TT_TC02 Passed - Stock details captured successfully");

    }


    //========================================================================================================//

    //TT_TestCase3 - Scenario: Check the Market mood on MMI (Market Mood Index) screen
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
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TT_TC03_MMIMarketZone");

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

        LoggerUtil.info("TT_TC03 Passed - MMI Range Identified and Captured snapshot");
    }

    //==============================================================================================

    //TT_TestCase4 - Scenario: FIND TOP 5 GAINERS

    @When("User is on the Dashboard or Homepage")
    public void userIsOnTheDashboardOrHomepage() throws InterruptedException {

        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//section[@class='jsx-1019738436 stock-t-container'])[1]")));

        WebElement element = driver.findElement(By.xpath("(//section[@class='jsx-1019738436 stock-t-container'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TT_TC04_Gainers");
    }

    @Then("top 5 gainers stock names should be displayed")
    public void display_top_5_gainers() {

        for (int i = 1; i <= 5; i++) {
            // Locate each stock element by its index in the loop
            WebElement stock = driver.findElement(By.xpath("(//span[@class='jsx-4123828227 typography-body-regular-xl text-primary mb4 d-block asset-name'])[" + i + "]"));

            // Get the text of the stock and print it
            String stockName = stock.getText();
            System.out.println("Gainer Stock " + i + ": " + stockName);
        }
        LoggerUtil.info("TT_TC04 Passed - Listed Top 5 Gainers of the day");

    }

    //=================================================================================================

    // TT_TestCase5 - Scenario: FIND TOP 5 LOSERS
    @When("clicks on losers button on Today's stocks section")
    public void clicksOnLosersButtonOnTodaySStocksSection() throws InterruptedException {

        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//section[@class='jsx-1019738436 stock-t-container'])[1]")));
        driver.findElement(By.xpath("(//span[text()='Losers'])[1]")).click();

        WebElement element = driver.findElement(By.xpath("(//section[@class='jsx-1019738436 stock-t-container'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        Thread.sleep(2000);
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TT_TC05_Losers");

    }

    @Then("top 5 losers stocks should be displayed")
    public void display_top_5_losers() {
        for (int i = 1; i <= 5; i++) {
            // Locate each stock element by its index in the loop
            WebElement stock = driver.findElement(By.xpath("(//span[@class='jsx-4123828227 typography-body-regular-xl text-primary mb4 d-block asset-name'])[" + i + "]"));

            // Get the text of the stock and print it
            String stockName = stock.getText();
            System.out.println("Loser Stock " + i + ": " + stockName);
        }
        LoggerUtil.info("TT_TC05 Passed - Listed Top 5 Losers of the day");

    }

    //======================================================================================================
    //TT_TestCase6 - Scenario: OPEN SITE, CLICK SEE ALL, GET NIFTY IT LTP
    @When("User clicks on See All button on the Index section Then choose the Sectoral button")
    public void userClicksOnSeeAllButtonOnTheIndexSectionThenChooseTheSectoralButton() {
        WebElement seeAll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//section[@class='jsx-1019738436 stock-t-container'])[1]")));
        driver.findElement(By.xpath("(//a[text()='See All'])[1]")).click();

        //span[@class='jsx-541417219 typography-body-medium-xs' and text()='Sectoral']
        WebElement sectoralButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='jsx-541417219 typography-body-medium-xs' and text()='Sectoral']")));
        driver.findElement(By.xpath("//span[@class='jsx-541417219 typography-body-medium-xs' and text()='Sectoral']")).click();

    }

    @Then("Nifty IT price should be printed")
    public void print_nifty_it_price() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div/div[1]/section/section/div/div/table/tbody/tr[9]/td[2]/span")));
        WebElement ITName = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div/div[1]/section/section/div/div/table/tbody/tr[9]/td[2]/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ITName);

        WebElement ITPrice = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div/div[1]/section/section/div/div/table/tbody/tr[9]/td[4]/span[1]"));
        System.out.println("=================================================");
        System.out.println( ITName.getText() +" --> "+ ITPrice.getText());
        System.out.println("=================================================");

        LoggerUtil.info("TT_TC06 Passed - Price of NIFTY IT printed as expected");

    }
//======================================================================================================

    // TT_TestCase7 - Scenario: FILTER THE TOP 5 SMALL CAP STOCKS IN TERMS OF MARKET CAP
    @When("Clicks on Screener menu and Clicks on Start Screening Option And Navigates to the Screener page")
    public void clicksOnScreenerMenuAndClicksOnStartScreeningOptionAndNavigatesToTheScreenerPage() {
        driver.findElement(By.xpath("//a[contains(@href,'/screener/home')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Start Screening']")));
        driver.findElement(By.xpath("//span[text()='Start Screening']")).click();

        user_navigates_to_mmi_page();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @When("Selects Small Cap option from the left pane")
    public void user_selects_small_cap_option() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio' and @name='segment-radio'])[1]")));
        driver.findElement(By.xpath("(//input[@type='radio' and @name='segment-radio'])[1]")).click();
        Thread.sleep(3000);
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TT_TC07_SmallCapStocksList");
    }

    @Then("Pick top 5 small cap stocks and Print them with Market cap")
    public void pickFirstSmallStocksAndPrintThemWithMarketCap() {

        for (int i = 1; i <= 5; i++) {
            // Locate each stock element by its index in the loop
            WebElement capName = driver.findElement(By.xpath("(//span[@class='jsx-427622308 desktop--only pointer'])["+ i +"]"));
            WebElement capPrice = driver.findElement(By.xpath("(//td[@class='jsx-427622308 mrktCapf-col  text-right']/span/span[@class='jsx-427622308 desktop--only'])["+i+"]"));

            // Get the text of the stock and print it
            String Name = capName.getText();
            String Price = capPrice.getText();

            System.out.println("StockName: "+Name+" -- MarketCap: "+Price);
        }
        LoggerUtil.info("TT_TC07 Passed - Top 5 Small cap stocks are verified successfully");
    }

    //======================================================================================================


    // TT_TestCase8 - Scenario: FILTER THE TOP 5 MID CAP STOCKS IN TERMS OF MARKET CAP
    @When("Selects Mid Cap option from the left pane")
    public void user_selects_mid_cap_option() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio' and @name='segment-radio'])[2]")));
        driver.findElement(By.xpath("(//input[@type='radio' and @name='segment-radio'])[2]")).click();
        Thread.sleep(3000);
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TT_TC08_MidCapStocksList");
    }

    @Then("Pick top 5 mid cap stocks and Print them with Market cap")
    public void pickFirstMidStocksAndPrintThemWithMarketCap() {

        for (int i = 1; i <= 5; i++) {
            // Locate each stock element by its index in the loop
            WebElement capName = driver.findElement(By.xpath("(//span[@class='jsx-427622308 desktop--only pointer'])[" + i + "]"));
            WebElement capPrice = driver.findElement(By.xpath("(//td[@class='jsx-427622308 mrktCapf-col  text-right']/span/span[@class='jsx-427622308 desktop--only'])[" + i + "]"));

            // Get the text of the stock and print it
            String Name = capName.getText();
            String Price = capPrice.getText();
            System.out.println("StockName: " + Name + " -- MarketCap: " + Price);
        }
        LoggerUtil.info("TT_TC08 Passed - Top 5 Mid cap stocks are verified successfully");

    }
//======================================================================================================

    // TT_TestCase9 - Scenario: FILTER THE TOP 5 LARGE CAP STOCKS IN TERMS OF MARKET CAP
    @When("Selects Large Cap option from the left pane")
    public void user_selects_large_cap_option() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio' and @name='segment-radio'])[3]")));
        driver.findElement(By.xpath("(//input[@type='radio' and @name='segment-radio'])[3]")).click();
        Thread.sleep(3000);
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TT_TC09_LargeCapStocksList");
        LoggerUtil.info("Screenshot Captured Successfully...!");
    }

    @Then("Pick top 5 large cap stocks and Print them with Market cap")
    public void pickFirstLargeStocksAndPrintThemWithMarketCap() {

        for (int i = 1; i <= 5; i++) {
            // Locate each stock element by its index in the loop
            WebElement capName = driver.findElement(By.xpath("(//span[@class='jsx-427622308 desktop--only pointer'])[" + i + "]"));
            WebElement capPrice = driver.findElement(By.xpath("(//td[@class='jsx-427622308 mrktCapf-col  text-right']/span/span[@class='jsx-427622308 desktop--only'])[" + i + "]"));

            // Get the text of the stock and print it
            String Name = capName.getText();
            String Price = capPrice.getText();
            System.out.println("StockName: " + Name + " -- MarketCap: " + Price);
        }
        LoggerUtil.info("TT_TC09 Passed - Top 5 Large cap stocks are verified successfully");
    }
}

//======================================================================================================
