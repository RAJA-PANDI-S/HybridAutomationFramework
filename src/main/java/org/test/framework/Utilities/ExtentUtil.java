package org.test.framework.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.pt.E;

public class ExtentUtil {
    public static ExtentReports extent;
    public static ExtentTest test;
    //private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public void startReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-report/reports/extent-code-report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public void extentCreateTest(String testName) {
        test = extent.createTest(testName);
        //testThreadLocal.set(test);  // Set the test instance in ThreadLocal to avoid overwriting
    }

    public void stopReport() {
        extent.flush();
    }

}
