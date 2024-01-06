package com.kychas.selenium.base;

/**
 * This class represents browsers. For add support of your browser - add it to this enum
 */
public enum  Browser {
    FIREFOX("firefox"),
    CHROME("chrome"),
    CHROMELINUX("chromeheadless"),
    IE10("ie10"),
    SAFARI("safari"),
    EDGE("edge");
    private String browserName;

    private Browser(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    /**
     * returns browser object by name
     * @param name name of browser
     * @return browser object
     */
    public static Browser getByName(String name){
        for(Browser browser : values()) {
            if(browser.getBrowserName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }

}
