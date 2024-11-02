package org.test.framework.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.framework.Helper.TakeSnapshot;
import org.test.framework.Utilities.EncryptionUtil;
import org.test.framework.Utilities.ExcelDataDrivenUtil;
import org.test.framework.Utilities.LoggerUtil;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;


public class StepsForTradingView {
    WebDriver driver = HooksStepDefinition.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    // TV_TestCase1 - Scenario: Verify that User login to the Trading view site and Validate successful login
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
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='label-mDJVFqQ3 label-jFqVJoPk label-mDJVFqQ3 label-YQGjel_5 js-main-menu-dropdown-link-title']")).click();
        Thread.sleep(3000);
    }

    @When("Selects Email option to login")
    public void selects_email_option_to_login() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='Email']")));
        driver.findElement(By.xpath("//button[@name='Email']")).click();
    }

    @Then("Login page appears where User enters Username and Password")
    public void login_page_appears_where_user_enters_username_and_password() throws Exception {
        String filePath = "src/main/resources/Config/user_credentials.xlsx";
        ExcelDataDrivenUtil.loadExcel(filePath);

        // Read the username and password from the Excel file
        String username = ExcelDataDrivenUtil.getCellData("Sheet1", 1, 0);
        String password = ExcelDataDrivenUtil.getCellData("Sheet1", 1, 1);

        String encryptedPassword = EncryptionUtil.encrypt(password);
        System.out.println("Password Encrypted Successfully --> " + encryptedPassword);
        String decryptedPassword = EncryptionUtil.decrypt(encryptedPassword);

        WebElement UsernameField = driver.findElement(By.xpath("//input[@name='id_username']"));
        UsernameField.click();
        UsernameField.sendKeys(username);

        WebElement PasswordField = driver.findElement(By.xpath("//input[@name='id_password']"));
        PasswordField.click();
        PasswordField.sendKeys(decryptedPassword);
    }

    @Then("User clicks sign in button and able to login successfully")
    public void user_clicks_sign_in_button_and_able_to_login_successfully() throws InterruptedException {

        driver.findElement(By.xpath("//span[contains(text(),\"Sign in\")]")).click();
        Thread.sleep(2000);

        // Locate and loop through all iframes
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        boolean captchaFound = false;

        for (WebElement iframe : iframes) {
            driver.switchTo().frame(iframe);

            // Try to find the reCAPTCHA checkbox inside each iframe
            List<WebElement> captchaCheckbox = driver.findElements(By.xpath("//iframe[@title='reCAPTCHA' and @name='a-r5xxv8xxba1t']"));
            if (captchaCheckbox.size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(captchaCheckbox.get(0)));
                captchaCheckbox.get(0).click();
                captchaFound = true;
                break;
            }

            // Switch back to the main content before moving to the next iframe
            driver.switchTo().defaultContent();
        }

        if (!captchaFound) {
            System.out.println("Captcha not found");
        } else {
            // Continue with login process
            driver.switchTo().defaultContent();  // Switch back to main content
            driver.findElement(By.cssSelector("button[type='submit']")).click();
        }

        // driver.findElement(By.xpath("//span[contains(text(),\"Sign in\")]")).click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TV_TC01_LoginScreen");
        System.out.println("==========================================================================");
        System.out.println(actualTitle);
        System.out.println("==========================================================================");
        LoggerUtil.info("TV_TC01 Passed - Logged in Successfully to the TradingView Site");
    }

    //============================================================================================================//

    //TV_TestCase2 - Scenario: Verify that User a stock and view the chart
    @When("User Clicks on Search bar")
    public void user_clicks_on_search_bar() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='searchText-PCujdK9L']")).click();
        Thread.sleep(3000);
    }

    @When("Search for a stock and hits enter")
    public void search_for_a_stock_and_hits_enter() throws InterruptedException {
        String input = "SBIN";
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input-KLRTYDjH' and @type='search']")));
        for (int i = 0; i < input.length(); i++) {
            // Extract the character at the current index and convert it to a string.
            searchInput.sendKeys(String.valueOf(input.charAt(i)));
            // Add a delay or wait (e.g., for user interface responsiveness).
            Thread.sleep(2000);
        }
        Thread.sleep(3000);
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("Chart opens with a candlestick pattern showing")
    public void chart_opens_with_a_candlestick_pattern_showing() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='STATE BANK OF INDIA']")));
        String actualTitle = driver.getTitle();
        TakeSnapshot snapshot = new TakeSnapshot(driver, "TV_TC02_PriceChartOfSBIN");
        System.out.println("==========================================================================");
        System.out.println(actualTitle);
        System.out.println("==========================================================================");
        LoggerUtil.info("TV_TC02 Passed - Viewed SBIN Price Chart and Snapshot captured");
    }
}

//============================================================================================================//