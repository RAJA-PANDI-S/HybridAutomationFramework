package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
//

import java.time.Duration;
import java.time.Instant;


public class StepDefinition {

    WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
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

    @Test
    //Test Case 2
    @Given("URL to the Tickertape site")
    public void url_to_the_tickertape_site() {
        System.out.println("TC2_This is Step 1");
        driver.navigate().to("https://www.tickertape.in/");
        driver.manage().window().maximize();
        System.out.println("Tickertape Started at \t" + Instant.now());
    }

    @When("User search a stock on Search bar")
    public void user_search_a_stock_on_search_bar() {
        System.out.println("TC2_This is Step 2");
        ////input[@id="search-stock-input"]
        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]"));
        searchBar.sendKeys("ITC");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // searchBar.sendKeys(Keys.ENTER);
        ////*[@id="stock-suggestion-ITC Ltd"]/div[1]
        //   driver.findElement(By.xpath("//*[@id=\"stock-suggestion-ITC Ltd\"]/div[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement stockSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='stock-suggestion-ITC Ltd']/div[1]")));
        stockSuggestion.click();
    }

    @Then("User should see the LTP of the stock")
    public void user_should_see_the_ltp_of_the_stock() {
        System.out.println("TC2_This is Step 3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String ITCPrice = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div/div/aside/div[1]/div[3]/span[1]")).getText();
        System.out.println(driver.getTitle());
        // Print the text
        System.out.println("Text inside the element: " + ITCPrice);

        float LTPofITC = Float.valueOf(ITCPrice.trim());  // Remove any leading/trailing spaces with .trim()
        System.out.println("Text inside the element: " + LTPofITC);
    }


    //TestCase3
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

// Print the Float value
        System.out.println("Integer value inside the element: " + marketMood);

        TakeSnapshot snapshot = new TakeSnapshot(driver, "Market");

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


    @After
    public void browserClose() {
        //driver.close();
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }
}

