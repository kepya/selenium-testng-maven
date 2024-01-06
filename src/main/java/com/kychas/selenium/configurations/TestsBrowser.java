package com.kychas.selenium.configurations;


import com.kychas.selenium.base.Browser;

/**
 * Class for base tests properties - urls for test, browser name and version
 */
public class TestsBrowser {
    private static TestsBrowser config;

    public static TestsBrowser getConfig() {
        if (config == null) {
            config = new TestsBrowser();
        }
        return config;
    }

    public TestsBrowser(String browser) {
        this.browser  = browser;
    }

    public TestsBrowser() {
        this.browser = "chrome";
    }

    private String browser;

    /**
     * getting browser object
     * @return browser object
     */
    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

}
