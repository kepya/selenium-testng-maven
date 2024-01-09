package com.kychas.selenium.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTest {

    public BaseTest() {
        new WebDriverFactory();
    }

    @BeforeTest
    public void beforeTest() {
        try {
            WebDriverFactory.initializedBrowser(false);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        WebDriverFactory.tearDown();
    }
}
