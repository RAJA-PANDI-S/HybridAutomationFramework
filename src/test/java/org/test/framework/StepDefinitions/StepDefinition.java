package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;

import java.time.Instant;



public class StepDefinition {

    WebDriver driver;

    @Before
    public void setUp() {
      //  WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
    }

    @Given("User is on google homepage")
    public void user_is_on_google_homepage() {
        System.out.println("This is Step 1");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
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
        // Verify the title using TestNG Assert
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected value!");
    }


    @After
    public void browserClose() {
        driver.close();
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }
}
