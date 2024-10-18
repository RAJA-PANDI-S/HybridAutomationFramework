package org.test.framework.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger("|");

    private LoggerUtil() {
        // Private constructor to prevent instantiation
    }

    public static void info(String message) {
        logger.info(getCallerClassName() + " | " + message);
    }

    public static void error(String message) {
        logger.error(getCallerClassName() + " | " + message);
    }

    // Method to get the calling class name using Thread stack trace
    private static String getCallerClassName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        // Adjust the index to find the right caller
        // The method calling `getCallerClassName` is at index 2, and the caller class is at index 3
        return stackTraceElements[3].getClassName();
    }
}
