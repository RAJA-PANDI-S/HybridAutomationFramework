package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Instant;

public class HooksStepDefinition {
   public static WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Browser launched");
    }

    @After
    public void browserClose() {
        //driver.close();
        driver.quit();
        System.out.println("Browser closed at \t" + Instant.now());
    }
}
