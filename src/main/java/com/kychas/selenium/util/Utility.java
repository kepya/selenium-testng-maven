package com.kychas.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	protected static String remote_url_firefox_dev = "http://localhost:4446/wd/hub";
	protected static String remote_url_firefox = "https://selenium-demo.londo-tech.com/wd/hub";
	protected static String remote_url_chrome = "http://localhost:4444/wd/hub";

	protected static Properties prop;
	public static boolean isLocal = false;
	protected static WebDriver driver;

	public void propertyInit() {
		prop = new Properties();

		try {
			FileInputStream file = new FileInputStream("src/main/resources/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void waitFor(WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(prop.getProperty("EXPLICIT_WAIT")));
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void getFailedTestCases(String testMethodName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			// String screenshots = System.getProperty("user.dir");
			FileUtils.copyFile(src, new File("screenshots/" + testMethodName + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
