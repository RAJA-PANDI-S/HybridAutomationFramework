package org.test.framework.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.framework.Utilities.ExtentUtil;
import org.test.framework.Utilities.LoggerUtil;


import java.time.Instant;

public class HooksStepDefinition {
   public static WebDriver driver;
    ExtentUtil extentUtil = new ExtentUtil();
   // Scenario scenario;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        extentUtil.startReport();
      //  extentUtil.extentCreateTest(scenario.getName());
        LoggerUtil.info("Chrome Browser Initiated Successfully");
    }

    @After
    public void browserClose() {
        // Log the result of the scenario (pass/fail)
      /*  if (scenario.isFailed()) {
            ExtentUtil.test.fail("Scenario Failed: " + scenario.getName());
        } else {
            ExtentUtil.test.pass("Scenario Passed: " + scenario.getName());
        } */
        driver.quit();
        extentUtil.stopReport();
        LoggerUtil.info("Chrome Browser Terminated Successfully");

    }
}
