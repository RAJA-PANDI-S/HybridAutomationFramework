package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.framework.Utilities.LoggerUtil;


import java.time.Instant;

public class HooksStepDefinition {
   public static WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raja\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        LoggerUtil.info("Chrome Browser Initiated Successfully");
    }

    @After
    public void browserClose() {
        //driver.close();
        driver.quit();
        LoggerUtil.info("Chrome Browser Terminated Successfully");

    }
}
