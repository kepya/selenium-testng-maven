package com.kychas.selenium.testcases;

import com.kychas.selenium.base.BaseTest;
import com.kychas.selenium.base.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class SampleTest extends BaseTest {

	public SampleTest() {
		super();
	}

	@Test
	public void openSite() {
		WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");
	}

	@Test
	public void adminLoginSuccessfully() {
		try {
			//open browser to link https://mcm-test.londo-tech.com/
			WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

			//get login btn element by classname
			WebElement button = WebDriverFactory.getDriver().findElement(By.className("login-btn"));
			button.click();

			//get email input element by xpath
			WebElement emailInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[1]/div/input"));
			emailInput.sendKeys("admin@mycimencam.com");

			//get password input element by xpat
			WebElement passwordInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[2]/div/input"));
			passwordInput.sendKeys("TlpH9t");

			//get login btn element by classname
			WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
			LoginBtn.click();

			WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
			By elementLocator = By.className("menubar-container");

			boolean isLogin = false;
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
				System.out.println("Element exists");
				isLogin = true;
			} catch (TimeoutException e) {
				System.out.println("Element does not exist");
				isLogin = false;
			}

			Assert.assertTrue(isLogin);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
