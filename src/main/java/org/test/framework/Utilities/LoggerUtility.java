package org.test.framework.Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtility {

    private static boolean root = false;

    @SuppressWarnings("rawtypes")
    public static Logger getLog(Class getclass) {
        if (root) {
            return Logger.getLogger(getclass);
        }
        String propertyFilePath = "//src//main//resources//config//";
        String logConfigFile = "log4j.properties";
        PropertyConfigurator.configure(System.getProperty("user.dir") + propertyFilePath + logConfigFile);
        root = true;
        return Logger.getLogger(getclass);

    }

}
