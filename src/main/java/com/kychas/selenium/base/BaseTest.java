package com.kychas.selenium.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTest {

    public BaseTest() {
        new WebDriverFactory();
    }

    @BeforeMethod
    public void beforeTest() {
        try {
            WebDriverFactory.initializedBrowser(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.tearDown();
    }
}
