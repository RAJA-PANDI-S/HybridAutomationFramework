package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Instant;

public class StepsForTradingView {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test

    @Given("URL for the Trading view Site and Selects sign option")
    public void url_for_the_trading_view_site_and_selects_sign_option() throws InterruptedException {
        System.out.println("This is Step 1");
        driver.navigate().to("https://in.tradingview.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("TradingView Started at \t" + Instant.now());
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/button[2]/svg")).click();
        driver.findElement(By.xpath("")).click(); ////span[contains(@class,'js-main-menu-dropdown-link-title')]
        driver.findElement(By.xpath("")).click();



    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("This is Step 2");

    }

    @When("Clicks on submit button for login")
    public void clicks_on_submit_button_for_login() {
        System.out.println("This is Step 3");

    }

    @Then("User able to view Dashboard and Ensure successful login")
    public void user_able_to_view_dashboard_and_ensure_successful_login() {
        System.out.println("This is Step 4");
    }




    @After
    public void browserClose() {
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }
}
