package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Instant;

@Slf4j
public class StepsForTradingView {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test

    //TEST CASE 1
    @Given("URL to the TradingView site")
    public void url_to_the_trading_view_site() {
        System.out.println("This is Step 1");
        driver.navigate().to("https://in.tradingview.com/");
        driver.manage().window().maximize();
        System.out.println("Site opened at \t" + Instant.now());

    }

    @When("User Clicks on Profile icon and Chooses Sign in option")
    public void user_clicks_on_profile_icon_and_chooses_sign_in_option() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']")).click();
        driver.findElement(By.xpath("//span[@class='label-mDJVFqQ3 label-jFqVJoPk label-mDJVFqQ3 label-YQGjel_5 js-main-menu-dropdown-link-title']")).click();
        Thread.sleep(3000);
    }

    @When("Selects Email option to login")
    public void selects_email_option_to_login() {
        driver.findElement(By.xpath("//button[@name='Email']")).click();

    }

    @Then("Login page appears where User enters Username and Password")
    public void login_page_appears_where_user_enters_username_and_password() {

        WebElement UsernameField = driver.findElement(By.xpath("//input[@name='id_username']"));
        UsernameField.click();
        UsernameField.sendKeys("raja.official.com@gmail.com");

        WebElement PasswordField = driver.findElement(By.xpath("//input[@name='id_password']"));
        PasswordField.click();
        PasswordField.sendKeys("17suca16");

    }

    @Then("User clicks sign in button and able to login successfully")
    public void user_clicks_sign_in_button_and_able_to_login_successfully() {

        driver.findElement(By.xpath("//span[contains(text(),\"Sign in\")]")).click();
        log.info("Logged in Successfully");

    }

    //============================================================================================

    //TEST CASE 2
    @Then("Login page appears where User enters invalid Username or Password")
    public void login_page_appears_where_user_enters_invalid_username_or_password() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("login should failed and info message should displayed as {string}")
    public void login_should_failed_and_info_message_should_displayed_as(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    //============================================================================================

    //TEST CASE 3
    @When("User Enters NIFTY in a search box")
    public void user_enters_nifty_in_search_box() {
        // Locate the search box and enter "NIFTY"

    }

    @When("user hit Enter and A Chart opens")
    public void user_hits_enter_and_chart_opens() {
        // Simulate hitting the Enter key to search for NIFTY

    }

    @Then("User clicks on stock screener option at the bottom")
    public void user_clicks_on_stock_screener_option() {
        // Locate and click the stock screener option

    }

    @Then("go to filter and chooses Health services in sector")
    public void user_chooses_health_services_in_sector() {
        // Locate the filter button and click on it

    }

    @Then("close the current popup now click export csv option to download the data")
    public void close_popup_and_click_export_csv() {
        // Close any pop-up that appears


    }

    //===========================================================================================

    @After
    public void browserClose() {
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }
}
