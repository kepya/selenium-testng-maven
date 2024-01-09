package com.kychas.selenium.base;

import com.kychas.selenium.configurations.TestsBrowser;
import com.kychas.selenium.util.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory extends Utility {

    /**
     * Getting of pre-configured {@link org.openqa.selenium.WebDriver} instance.
     * Please use this method only after call {@link #initializedBrowser(boolean) startBrowser} method
     *
     * @return webdriver object, or throw IllegalStateException, if driver has not been initialized
     */
    public WebDriverFactory() {
        propertyInit();
    }

    /**
     * Getting of pre-configured {@link org.openqa.selenium.WebDriver} instance.
     * Please use this method only after call {@link #initializedBrowser(boolean) startBrowser} method
     *
     * @return webdriver object, or throw IllegalStateException, if driver has not been initialized
     */
    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }


    /**
     * Main method of class - it initialize driver and starts browser.
     *
     * @param isLocal - is tests will be started local or not
     */
    public static void initializedBrowser(boolean isLocal) throws MalformedURLException {
        if (driver == null) {
            TestsBrowser testsBrowser = new TestsBrowser(prop.getProperty("Browser"));
            Browser browser = testsBrowser.getBrowser();

            if (!isLocal) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL(remote_url_firefox), options);
            } else {
                switch (browser) {
                    case FIREFOX:
                        FirefoxOptions options4 = new FirefoxOptions();
                        options4.merge(CapabilitiesGenerator.getDefaultCapabilities(Browser.FIREFOX));
                        driver = new FirefoxDriver(options4);
                        break;
                    case EDGE:
                        EdgeOptions options5 = new EdgeOptions();
                        options5.merge(CapabilitiesGenerator.getDefaultCapabilities(Browser.FIREFOX));
                        driver = new EdgeDriver(options5);
                        break;
                    case CHROME:
                        ChromeOptions options1 = new ChromeOptions();
                        options1.merge(CapabilitiesGenerator.getDefaultCapabilities(Browser.CHROME));
                        driver = new ChromeDriver(options1);
                        break;
                    case IE10:
                        InternetExplorerOptions options2 = new InternetExplorerOptions();
                        options2.merge(CapabilitiesGenerator.getDefaultCapabilities(Browser.IE10));
                        driver = new InternetExplorerDriver(options2);
                        break;
                    case SAFARI:
                        SafariOptions options3 = new SafariOptions();
                        options3.merge(CapabilitiesGenerator.getDefaultCapabilities(Browser.SAFARI));
                        driver = new SafariDriver(options3);
                        break;
                    case CHROMELINUX:
                        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("addArguments");
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("--headless");
                        //options.addArguments("start-maximized");
                        options.addArguments("disable-infobars");
                        //options.addArguments("--disable-extensions");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-browser-side-navigation");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-gpu");
                        driver = new ChromeDriver(options);
                        break;
                    default:
                        throw new IllegalStateException("Unsupported browser type");
                }
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            }
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    /**
     * Finishes browser
     */
    public static void tearDown() {
        // closes all the browser windows opened by web driver
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
