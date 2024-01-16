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

import static com.kychas.selenium.util.Utility.isLocal;
import static org.testng.Assert.fail;

public class SampleTest extends BaseTest {

	public SampleTest() {
		super();
	}

	@Test
	public void openSite() {
        if (isLocal){
            WebDriverFactory.getDriver().get("http://localhost:4200");
        } else {
            WebDriverFactory.getDriver().get("http://34.31.34.41:8082");
        }
	}

	@Test
	public void adminLoginSuccessfully() {
		try {
            if (isLocal){
                WebDriverFactory.getDriver().get("http://localhost:4200");
            } else {
                WebDriverFactory.getDriver().get("http://34.31.34.41:8082");
            }

			WebElement button = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/app-root/app-home/div[1]/div/section/button[1]"));
			button.click();

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
            By nomLocator = By.xpath("/html/body/app-root/app-register/div/div/form/input[1]");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(nomLocator));
                WebElement nomInput = WebDriverFactory.getDriver().findElement(nomLocator);
                nomInput.sendKeys("Kychas");
                System.out.println("Element exists");
            } catch (TimeoutException e) {
                fail("Element does not exist");
            }

            By prenomLocator = By.xpath("/html/body/app-root/app-register/div/div/form/input[2]");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(prenomLocator));
                WebElement prenomInput = WebDriverFactory.getDriver().findElement(prenomLocator);
                prenomInput.sendKeys("Kychas");
                System.out.println("Element exists");
            } catch (TimeoutException e) {
                fail("Element does not exist");
            }

            By usernameLocator = By.xpath("/html/body/app-root/app-register/div/div/form/input[3]");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
                WebElement usernameInput = WebDriverFactory.getDriver().findElement(usernameLocator);
                usernameInput.sendKeys("Kychas");
                System.out.println("Element exists");
            } catch (TimeoutException e) {
                fail("Element does not exist");
            }

            By phoneLocator = By.xpath("/html/body/app-root/app-register/div/div/form/input[4]");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(phoneLocator));
                WebElement phoneInput = WebDriverFactory.getDriver().findElement(phoneLocator);
                phoneInput.sendKeys("680670670");
                System.out.println("Element exists");
            } catch (TimeoutException e) {
                fail("Element does not exist");
            }

            By emailLocator = By.xpath("/html/body/app-root/app-register/div/div/form/input[5]");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
                WebElement emailInput = WebDriverFactory.getDriver().findElement(emailLocator);
                emailInput.sendKeys("admin@mycimencam.com");
                System.out.println("Element exists");
            } catch (TimeoutException e) {
                fail("Element does not exist");
            }

            By passwordLocator = By.xpath("/html/body/app-root/app-register/div/div/form/input[6]");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
                WebElement passwordInput = WebDriverFactory.getDriver().findElement(passwordLocator);
                passwordInput.sendKeys("Azerty@12");
                System.out.println("Element exists");
            } catch (TimeoutException e) {
                fail("Element does not exist");
            }

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
