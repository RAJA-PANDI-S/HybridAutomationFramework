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

    @Given("URL to the TradingView site")
    public void url_to_the_trading_view_site() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("User Clicks on Profile icon and Chooses Sign in option")
    public void user_clicks_on_profile_icon_and_chooses_sign_in_option() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("Selects Email option to login")
    public void selects_email_option_to_login() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("Login page appears where User enters Username and Password")
    public void login_page_appears_where_user_enters_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("User clicks sign in button and able to login successfully")
    public void user_clicks_sign_in_button_and_able_to_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
    }

    @After
    public void browserClose() {
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }
}
