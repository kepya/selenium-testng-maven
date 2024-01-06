package com.kychas.selenium.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public BaseTest() {
        new WebDriverFactory();
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.initializedBrowser(true);
    }

    @AfterTest
    public void tearDown() {
        WebDriverFactory.tearDown();
    }
}
