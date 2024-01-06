package com.kychas.selenium.testcases.cimencam;

import com.kychas.selenium.base.BaseTest;
import com.kychas.selenium.base.WebDriverFactory;
import com.kychas.selenium.util.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.fail;


public class OtherMenuTest extends BaseTest {

    public OtherMenuTest() {
        super();
    }

    @Test
    public void bankStatementWithSendBtn() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
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

            // Find the withdrawal date field element
            By withdrawalInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[1]/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputLocator));
                WebElement withdrawalInput = WebDriverFactory.getDriver().findElement(withdrawalInputLocator);
                if (withdrawalInput.isDisplayed() && withdrawalInput.isEnabled()) {
                    withdrawalInput.click();

                    By withdrawalCalendarLocator = By.className("today");
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                        WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                        if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                            JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                            executor.executeScript("arguments[0].click();", withdrawalCalendar);
                        }
                    } catch (TimeoutException e) {
                        fail("withdrawal calendar does not showing so we got a problem");
                    }
                }

                // Find the withdrawal date field element
                By withdrawalInputEndDateLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[2]/input");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputEndDateLocator));
                    WebElement withdrawalInputEndDate = WebDriverFactory.getDriver().findElement(withdrawalInputEndDateLocator);
                    if (withdrawalInputEndDate.isDisplayed() && withdrawalInputEndDate.isEnabled()) {
                        withdrawalInputEndDate.click();

                        By withdrawalCalendarLocator = By.className("today");
                        try {
                            wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                            WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                            if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                                executor.executeScript("arguments[0].click();", withdrawalCalendar);
                            }
                        } catch (TimeoutException e) {
                            fail("withdrawal calendar does not showing so we got a problem");
                        }
                    }
                } catch (TimeoutException e) {
                    fail("withdrawal input does not exist so we got a problem");
                }

            } catch (Exception e) {
                fail("We cannot view schedule");
            }

            //get login btn element by classname
            By sendButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-footer/button[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(sendButtonLocator));
                WebElement sendButton = WebDriverFactory.getDriver().findElement(sendButtonLocator);
                if (sendButton.isEnabled() && sendButton.isDisplayed()) {
                    sendButton.click();
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
    public void bankStatementWithCancelBtn() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
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

            // Find the withdrawal date field element
            By withdrawalInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[1]/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputLocator));
                WebElement withdrawalInput = WebDriverFactory.getDriver().findElement(withdrawalInputLocator);
                if (withdrawalInput.isDisplayed() && withdrawalInput.isEnabled()) {
                    withdrawalInput.click();

                    By withdrawalCalendarLocator = By.className("today");
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                        WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                        if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                            JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                            executor.executeScript("arguments[0].click();", withdrawalCalendar);
                        }
                    } catch (TimeoutException e) {
                        fail("withdrawal calendar does not showing so we got a problem");
                    }
                }

                // Find the withdrawal date field element
                By withdrawalInputEndDateLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[2]/input");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputEndDateLocator));
                    WebElement withdrawalInputEndDate = WebDriverFactory.getDriver().findElement(withdrawalInputEndDateLocator);
                    if (withdrawalInputEndDate.isDisplayed() && withdrawalInputEndDate.isEnabled()) {
                        withdrawalInputEndDate.click();

                        By withdrawalCalendarLocator = By.className("today");
                        try {
                            wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                            WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                            if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                                executor.executeScript("arguments[0].click();", withdrawalCalendar);
                            }
                        } catch (TimeoutException e) {
                            fail("withdrawal calendar does not showing so we got a problem");
                        }
                    }
                } catch (TimeoutException e) {
                    fail("withdrawal input does not exist so we got a problem");
                }

            } catch (Exception e) {
                fail("We cannot view schedule");
            }

            //get login btn element by classname
            By cancelButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
                WebElement cancelButton = WebDriverFactory.getDriver().findElement(cancelButtonLocator);
                if (cancelButton.isEnabled() && cancelButton.isDisplayed()) {
                    cancelButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void showAccountValue() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
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
            TimeUtils.waitForSeconds(2);

            //get login btn element by classname
            By cancelButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-balance-account/div/nb-card/nb-card-footer/button");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
                WebElement cancelButton = WebDriverFactory.getDriver().findElement(cancelButtonLocator);
                if (cancelButton.isEnabled() && cancelButton.isDisplayed()) {
                    cancelButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void aeNotChargedWithCancelButton() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
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

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[3]");
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

            //get login btn element by classname
            By cancelButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-ae-not-charged/div/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
                WebElement cancelButton = WebDriverFactory.getDriver().findElement(cancelButtonLocator);
                if (cancelButton.isEnabled() && cancelButton.isDisplayed()) {
                    cancelButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

            TimeUtils.waitForSeconds(3);
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
    public void aeNotChargedWithSendButton() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
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

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

            //get login btn element by classname
            By sendButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-ae-not-charged/div/nb-card/nb-card-footer/button[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(sendButtonLocator));
                WebElement sendButton = WebDriverFactory.getDriver().findElement(sendButtonLocator);
                if (sendButton.isEnabled() && sendButton.isDisplayed()) {
                    sendButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void editingInvoicesTestByPeriod() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[4]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        //select edition by period
        By startDateInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-body/div/div/div/nb-tabset/nb-tab[1]/input[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(startDateInputLocator));
            WebElement startDateInput = WebDriverFactory.getDriver().findElement(startDateInputLocator);
            if (startDateInput.isEnabled() && startDateInput.isDisplayed()) {
                startDateInput.click();

                By startDateInputLocator1 = By.className("today");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(startDateInputLocator1));
                    WebElement startDateInputValue = WebDriverFactory.getDriver().findElement(startDateInputLocator1);
                    if (startDateInputValue.isDisplayed() && startDateInputValue.isEnabled()) {
                        JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                        executor.executeScript("arguments[0].click();", startDateInputValue);
                    }
                } catch (TimeoutException e) {
                    fail("start input for editing bill calendar does not showing so we got a problem");
                }
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found input of start date for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        //select edition by period
        By endDateInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-body/div/div/div/nb-tabset/nb-tab[1]/input[2]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(endDateInputLocator));
            WebElement endDateInput = WebDriverFactory.getDriver().findElement(endDateInputLocator);
            if (endDateInput.isEnabled() && endDateInput.isDisplayed()) {
                endDateInput.click();

                By endDateInputLocator1 = By.className("today");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(endDateInputLocator1));
                    WebElement endDateInputValue = WebDriverFactory.getDriver().findElement(endDateInputLocator1);
                    if (endDateInputValue.isDisplayed() && endDateInputValue.isEnabled()) {
                        JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                        executor.executeScript("arguments[0].click();", endDateInputValue);
                    }
                } catch (TimeoutException e) {
                    fail("end input for editing bill calendar does not showing so we got a problem");
                }
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found input of end date for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        By editBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-footer/button[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(editBtnLocator));
            WebElement editBtn = WebDriverFactory.getDriver().findElement(editBtnLocator);
            if (editBtn.isEnabled() && editBtn.isDisplayed()) {
                editBtn.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found button for save for edition of invoice");
        }

    }

    @Test
    public void editingInvoicesTestByPeriod1() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[4]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        //select edition by period
        By startDateInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-body/div/div/div/nb-tabset/nb-tab[1]/input[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(startDateInputLocator));
            WebElement startDateInput = WebDriverFactory.getDriver().findElement(startDateInputLocator);
            if (startDateInput.isEnabled() && startDateInput.isDisplayed()) {
                startDateInput.click();

                By startDateInputLocator1 = By.className("today");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(startDateInputLocator1));
                    WebElement startDateInputValue = WebDriverFactory.getDriver().findElement(startDateInputLocator1);
                    if (startDateInputValue.isDisplayed() && startDateInputValue.isEnabled()) {
                        JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                        executor.executeScript("arguments[0].click();", startDateInputValue);
                    }
                } catch (TimeoutException e) {
                    fail("start input for editing bill calendar does not showing so we got a problem");
                }
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found input of start date for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        //select edition by period
        By endDateInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-body/div/div/div/nb-tabset/nb-tab[1]/input[2]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(endDateInputLocator));
            WebElement endDateInput = WebDriverFactory.getDriver().findElement(endDateInputLocator);
            if (endDateInput.isEnabled() && endDateInput.isDisplayed()) {
                endDateInput.click();

                By endDateInputLocator1 = By.className("today");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(endDateInputLocator1));
                    WebElement endDateInputValue = WebDriverFactory.getDriver().findElement(endDateInputLocator1);
                    if (endDateInputValue.isDisplayed() && endDateInputValue.isEnabled()) {
                        JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                        executor.executeScript("arguments[0].click();", endDateInputValue);
                    }
                } catch (TimeoutException e) {
                    fail("end input for editing bill calendar does not showing so we got a problem");
                }
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found input of end date for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        By cancelBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-footer/button[2]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelBtnLocator));
            WebElement cancelBtn = WebDriverFactory.getDriver().findElement(cancelBtnLocator);
            if (cancelBtn.isEnabled() && cancelBtn.isDisplayed()) {
                cancelBtn.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found button for cancel for edition of invoice");
        }
        TimeUtils.waitForSeconds(1);
    }

    @Test
    public void doReclamation() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[5]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        // Show the delivery mode
        By categorySelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[4]/div/nb-option-list/ul/nb-option[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(categorySelectLocator));
            WebElement categorySelect = WebDriverFactory.getDriver().findElement(categorySelectLocator);
            if (categorySelect.isDisplayed() && categorySelect.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", categorySelect);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select does not exist so we got a problem");
        }

        // Show the delivery mode option and select pick up
        By categorySelectOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[4]/div/nb-option-list/ul/nb-option[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(categorySelectOptionLocator));
            WebElement categorySelectOption = WebDriverFactory.getDriver().findElement(categorySelectOptionLocator);
            if (categorySelectOption.isDisplayed() && categorySelectOption.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", categorySelectOption);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select option does not exist so we got a problem");
        }


        // Show the delivery mode
        By motifReclamationSelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-feedbacks-form/div/nb-card/nb-card-body/div/div[1]/nb-select");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(motifReclamationSelectLocator));
            WebElement motifReclamationSelect = WebDriverFactory.getDriver().findElement(motifReclamationSelectLocator);
            if (motifReclamationSelect.isDisplayed() && motifReclamationSelect.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", motifReclamationSelect);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select does not exist so we got a problem");
        }

        // Show the delivery mode option and select pick up
        By motifSelectOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[4]/div/nb-option-list/ul/nb-option[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(motifSelectOptionLocator));
            WebElement motifSelectOption = WebDriverFactory.getDriver().findElement(motifSelectOptionLocator);
            if (motifSelectOption.isDisplayed() && motifSelectOption.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", motifSelectOption);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select option does not exist so we got a problem");
        }

        By contentReclamationLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-feedbacks-form/div/nb-card/nb-card-body/div/div[3]/textarea");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(contentReclamationLocator));
            WebElement contentReclamation = WebDriverFactory.getDriver().findElement(contentReclamationLocator);
            if (contentReclamation.isEnabled() && contentReclamation.isDisplayed()) {
                contentReclamation.sendKeys("test");
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        By cancelBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-footer/button[2]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelBtnLocator));
            WebElement cancelBtn = WebDriverFactory.getDriver().findElement(cancelBtnLocator);
            if (cancelBtn.isEnabled() && cancelBtn.isDisplayed()) {
                cancelBtn.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found button for cancel for edition of invoice");
        }
        TimeUtils.waitForSeconds(1);
    }

    @Test
    public void doReclamation1() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[5]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        // Show the delivery mode
        By categorySelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[4]/div/nb-option-list/ul/nb-option[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(categorySelectLocator));
            WebElement categorySelect = WebDriverFactory.getDriver().findElement(categorySelectLocator);
            if (categorySelect.isDisplayed() && categorySelect.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", categorySelect);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select does not exist so we got a problem");
        }

        // Show the delivery mode option and select pick up
        By categorySelectOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[4]/div/nb-option-list/ul/nb-option[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(categorySelectOptionLocator));
            WebElement categorySelectOption = WebDriverFactory.getDriver().findElement(categorySelectOptionLocator);
            if (categorySelectOption.isDisplayed() && categorySelectOption.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", categorySelectOption);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select option does not exist so we got a problem");
        }


        // Show the delivery mode
        By motifReclamationSelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-feedbacks-form/div/nb-card/nb-card-body/div/div[1]/nb-select");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(motifReclamationSelectLocator));
            WebElement motifReclamationSelect = WebDriverFactory.getDriver().findElement(motifReclamationSelectLocator);
            if (motifReclamationSelect.isDisplayed() && motifReclamationSelect.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", motifReclamationSelect);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select does not exist so we got a problem");
        }

        // Show the delivery mode option and select pick up
        By motifSelectOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[4]/div/nb-option-list/ul/nb-option[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(motifSelectOptionLocator));
            WebElement motifSelectOption = WebDriverFactory.getDriver().findElement(motifSelectOptionLocator);
            if (motifSelectOption.isDisplayed() && motifSelectOption.isEnabled()) {
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", motifSelectOption);
            }
        } catch (TimeoutException e) {
            fail("delivery mode select option does not exist so we got a problem");
        }

        By contentReclamationLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-feedbacks-form/div/nb-card/nb-card-body/div/div[3]/textarea");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(contentReclamationLocator));
            WebElement contentReclamation = WebDriverFactory.getDriver().findElement(contentReclamationLocator);
            if (contentReclamation.isEnabled() && contentReclamation.isDisplayed()) {
                contentReclamation.sendKeys("test");
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);
        By sendBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-edit-invoices/div/nb-card/nb-card-footer/button[1]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(sendBtnLocator));
            WebElement sendBtn = WebDriverFactory.getDriver().findElement(sendBtnLocator);
            if (sendBtn.isEnabled() && sendBtn.isDisplayed()) {
                sendBtn.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found button for cancel for edition of invoice");
        }
        TimeUtils.waitForSeconds(1);
    }

    @Test
    public void showReclamation() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[6]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

    }

    @Test
    public void showFAQ() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[7]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

    }

    @Test
    public void showTermOfCondition() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[8]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

    }

    @Test
    public void showLexique() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[10]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

    }


    @Test
    public void showTechnicalFiche() {
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
            fail("Login failed. We think api doesn't return a good respond");
        }

        TimeUtils.waitForSeconds(1);
        By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
            WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
            if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                orderMenu.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found menu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

        By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[9]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
            WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
            if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                orderListFirstOption1.click();
            }
        } catch (TimeoutException e) {
            fail("You are login but we cannot found submenu for edition of invoice");
        }

        TimeUtils.waitForSeconds(1);

    }
}
