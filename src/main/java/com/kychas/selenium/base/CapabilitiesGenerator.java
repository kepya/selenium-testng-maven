package com.kychas.selenium.base;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesGenerator {
    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return DesiredCapabilities.firefox();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.chrome();
            case IE10:
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setVersion("10");
                return caps;
            case SAFARI:
            case EDGE:
            case CHROMELINUX:
                return new DesiredCapabilities();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }
}
