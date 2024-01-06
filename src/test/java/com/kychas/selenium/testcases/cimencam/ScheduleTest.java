package com.kychas.selenium.testcases.cimencam;

import com.kychas.selenium.base.BaseTest;
import com.kychas.selenium.base.WebDriverFactory;
import com.kychas.selenium.util.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.fail;

public class ScheduleTest extends BaseTest {

    public ScheduleTest() {
        super();
    }

    @Test
    public void delivery() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
            //open browser to link https://mcm-test.londo-tech.com/
            WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

            //get login btn element by classname
            WebElement button = WebDriverFactory.getDriver().findElement(By.className("login-btn"));
            button.click();

            //get email input element by xpath
            WebElement emailInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[1]/div/input"));
            emailInput.sendKeys("soceprob111@gmail.com");

            //get password input element by xpat
            WebElement passwordInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[2]/div/input"));
            passwordInput.sendKeys("SOCEPROB");

            //get login btn element by classname
            WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
            LoginBtn.click();

            TimeUtils.waitForSeconds(1);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }


            TimeUtils.waitForSeconds(1);
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            }
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void delivery1() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
            //open browser to link https://mcm-test.londo-tech.com/
            WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

            //get login btn element by classname
            WebElement button = WebDriverFactory.getDriver().findElement(By.className("login-btn"));
            button.click();

            //get email input element by xpath
            WebElement emailInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[1]/div/input"));
            emailInput.sendKeys("soceprob111@gmail.com");

            //get password input element by xpat
            WebElement passwordInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[2]/div/input"));
            passwordInput.sendKeys("SOCEPROB");

            //get login btn element by classname
            WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
            LoginBtn.click();

            TimeUtils.waitForSeconds(2);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }


            TimeUtils.waitForSeconds(1);
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            }
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }
}
