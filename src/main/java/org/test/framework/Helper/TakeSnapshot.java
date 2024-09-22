package org.test.framework.Helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class TakeSnapshot {
    public TakeSnapshot(WebDriver driver, String fileName) {
        // Create a path inside the project for screenshots
        String filePath = "C:\\Users\\Raja\\IntellijProjects\\HybridAutomationFramework\\src\\test\\resources\\Logs";

        // Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(filePath + "\\" + fileName + ".png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Screenshot saved at: " + filePath + "\\" + fileName + ".png");
    }
}



