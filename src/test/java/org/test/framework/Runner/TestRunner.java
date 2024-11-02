package org.test.framework.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "org.test.framework.StepDefinitions",
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber/report/report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "junit:target/cucumber/report/report.xml"},
        tags = "@YF_TestCase2",
        //  plugin = {"tech.grasshopper.extent.cucumber6.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
