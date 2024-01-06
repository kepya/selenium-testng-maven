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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.fail;

public class HomeMenuTest extends BaseTest {

    public HomeMenuTest() {
        super();
    }

    @Test
    public void home() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[1]");
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
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void myAccount() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[1]");
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
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void logout() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[1]");
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

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[4]");
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
            By elementLocator1 = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator1));
                fail("Logout failed");
            } catch (TimeoutException e) {
                Assert.assertTrue(true);
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void newOrder() {
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
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[1]");
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
            By storeSelectLocator = By.id("storeSelect");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(storeSelectLocator));
                WebElement storeSelect = WebDriverFactory.getDriver().findElement(storeSelectLocator);
                storeSelect.click();
            } catch (TimeoutException e) {
                fail("store select does not exist so we didn't login already");
            }

            By storeSelectOptionLocator = By.id("nb-option-0");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(storeSelectOptionLocator));
                WebElement storeSelectOption = WebDriverFactory.getDriver().findElement(storeSelectOptionLocator);
                storeSelectOption.click();
                TimeUtils.waitForSeconds(4);
            } catch (TimeoutException e) {
                fail("store select option does not exist so we got a problem");
            }

            //get add article btn element by xpath
            By addArticleBtnLocator = By.className("add-elt-btn");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(addArticleBtnLocator));
                WebElement addArticleBtn = WebDriverFactory.getDriver().findElement(addArticleBtnLocator);
                if (addArticleBtn.isDisplayed() && addArticleBtn.isEnabled()) {
                    addArticleBtn.click();
                }
            } catch (TimeoutException e) {
                fail("article btn add does not exist so we got a problem");
            }

            // Show the list of product
            By productSelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/ul/li[2]/div[2]/nb-select");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(productSelectLocator));
                WebElement productSelect = WebDriverFactory.getDriver().findElement(productSelectLocator);
                if (productSelect.isDisplayed() && productSelect.isEnabled()) {
                    productSelect.click();
                }
            } catch (TimeoutException e) {
                fail("product select does not exist so we got a problem");
            }

            // Show the list of product
            By productSelectOptionLocator = By.id("nb-option-9");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(productSelectOptionLocator));
                WebElement productSelectOption = WebDriverFactory.getDriver().findElement(productSelectOptionLocator);
                if (productSelectOption.isDisplayed() && productSelectOption.isEnabled()) {
                    productSelectOption.click();
                }
            } catch (TimeoutException e) {
                fail("product select option does not exist so we got a problem");
            }

            // Find the quantity field element for add quantity of product
            By quantityInBagFieldLocator = By.className("quantity-field");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(quantityInBagFieldLocator));
                WebElement quantityInBagField = WebDriverFactory.getDriver().findElement(quantityInBagFieldLocator);
                if (quantityInBagField.isDisplayed() && quantityInBagField.isEnabled()) {
                    quantityInBagField.sendKeys("1");
                }
            } catch (TimeoutException e) {
                fail("Input field quantity does not exist so we got a problem");
            }

            //get schedule article btn element by xpath
            By scheduleArticleBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/div[2]/button");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(scheduleArticleBtnLocator));
                WebElement scheduleArticleBtn = WebDriverFactory.getDriver().findElement(scheduleArticleBtnLocator);
                if (scheduleArticleBtn.isDisplayed() && scheduleArticleBtn.isEnabled()) {
                    scheduleArticleBtn.click();
                }
            } catch (TimeoutException e) {
                fail("article btn schedule does not exist so we got a problem");
            }

            //get schedule product in schedule page btn element
            By schedule1ArticleBtnLocator = By.className("add-elt-btn");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(schedule1ArticleBtnLocator));
                WebElement schedule1ArticleBtn = WebDriverFactory.getDriver().findElement(schedule1ArticleBtnLocator);
                if (schedule1ArticleBtn.isDisplayed() && schedule1ArticleBtn.isEnabled()) {
                    schedule1ArticleBtn.click();
                }
            } catch (TimeoutException e) {
                fail("article btn schedule 1 does not exist so we got a problem");
            }

            // Find the withdrawal date field element
            By withdrawalInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[1]/input");
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
            } catch (TimeoutException e) {
                fail("withdrawal input does not exist so we got a problem");
            }

            // Show the list of quart time
            By quartTimeSelectLocator = By.id("quartSelect");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(quartTimeSelectLocator));
                wait.until(ExpectedConditions.elementToBeClickable(quartTimeSelectLocator));
                WebElement quartTimeSelect = WebDriverFactory.getDriver().findElement(quartTimeSelectLocator);
                if (quartTimeSelect.isDisplayed() && quartTimeSelect.isEnabled()) {
                    JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                    executor.executeScript("arguments[0].click();", quartTimeSelect);
                }
            } catch (TimeoutException e) {
                fail("quartTime select does not exist so we got a problem");
            }

            // Show the list of quart time option
            By quartTimeSelectOptionLocator = By.id("nb-option-12");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(quartTimeSelectOptionLocator));
                WebElement quartTimeSelectOption = WebDriverFactory.getDriver().findElement(quartTimeSelectOptionLocator);
                if (quartTimeSelectOption.isDisplayed() && quartTimeSelectOption.isEnabled()) {
                    quartTimeSelectOption.click();
                }
            } catch (TimeoutException e) {
                fail("quartTime select option does not exist so we got a problem");
            }

            // get the quantity field element in tone
            By quantityInToneInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[5]/div/div[1]/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(quantityInToneInputLocator));
                WebElement quantityInToneInput = WebDriverFactory.getDriver().findElement(quantityInToneInputLocator);
                if (quantityInToneInput.isDisplayed() && quantityInToneInput.isEnabled()) {
                    quantityInToneInput.sendKeys("0.05");
                }
            } catch (TimeoutException e) {
                fail("quantity in tonne field does not exist so we got a problem");
            }

            // get the quantity of truck element in tone
            By quantityOfTruckInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[5]/div/div[2]/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(quantityOfTruckInputLocator));
                WebElement quantityOfTruckInput = WebDriverFactory.getDriver().findElement(quantityOfTruckInputLocator);
                if (quantityOfTruckInput.isDisplayed() && quantityOfTruckInput.isEnabled()) {
                    quantityOfTruckInput.sendKeys("1");
                }
            } catch (TimeoutException e) {
                fail("quantity of truck field does not exist so we got a problem");
            }

            // Save schedule
            By saveScheduleBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(saveScheduleBtnLocator));
                WebElement saveScheduleBtn = WebDriverFactory.getDriver().findElement(saveScheduleBtnLocator);
                if (saveScheduleBtn.isDisplayed() && saveScheduleBtn.isEnabled()) {
                    saveScheduleBtn.click();
                }
            } catch (TimeoutException e) {
                fail("save schedule btn does not exist so we got a problem");
            }

            // Go on next step
            By nextStepAfterScheduleBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery/div/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(nextStepAfterScheduleBtnLocator));
                WebElement nextStepAfterScheduleBtn = WebDriverFactory.getDriver().findElement(nextStepAfterScheduleBtnLocator);
                if (nextStepAfterScheduleBtn.isDisplayed() && nextStepAfterScheduleBtn.isEnabled()) {
                    nextStepAfterScheduleBtn.click();
                }
            } catch (TimeoutException e) {
                fail("next step btn does not exist so we got a problem");
            }

            // Show the delivery mode
            By deliveryModeSelectLocator = By.id("companyAccountSelect");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(deliveryModeSelectLocator));
                WebElement deliveryModeSelect = WebDriverFactory.getDriver().findElement(deliveryModeSelectLocator);
                if (deliveryModeSelect.isDisplayed() && deliveryModeSelect.isEnabled()) {
                    JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                    executor.executeScript("arguments[0].click();", deliveryModeSelect);
                }
            } catch (TimeoutException e) {
                fail("delivery mode select does not exist so we got a problem");
            }

            // Show the delivery mode option and select pick up
            By deliveryModeSelectOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[2]/div/nb-option-list/ul/nb-option[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(deliveryModeSelectOptionLocator));
                WebElement deliveryModeSelectOption = WebDriverFactory.getDriver().findElement(deliveryModeSelectOptionLocator);
                if (deliveryModeSelectOption.isDisplayed() && deliveryModeSelectOption.isEnabled()) {
                    JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                    executor.executeScript("arguments[0].click();", deliveryModeSelectOption);
                }
            } catch (TimeoutException e) {
                fail("delivery mode select option does not exist so we got a problem");
            }

            // Show the payment mode
            By paymentModeSelectLocator = By.id("paymentModeSelect");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(paymentModeSelectLocator));
                WebElement paymentModeSelect = WebDriverFactory.getDriver().findElement(paymentModeSelectLocator);
                if (paymentModeSelect.isDisplayed() && paymentModeSelect.isEnabled()) {
                    JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                    executor.executeScript("arguments[0].click();", paymentModeSelect);
                }
            } catch (TimeoutException e) {
                fail("payment mode select does not exist so we got a problem");
            }

            // Show the payment mode option and select mtn payment
            By paymentModeSelectOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[2]/div/nb-option-list/ul/nb-option[4]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(paymentModeSelectOptionLocator));
                WebElement paymentModeSelectOption = WebDriverFactory.getDriver().findElement(paymentModeSelectOptionLocator);
                if (paymentModeSelectOption.isDisplayed() && paymentModeSelectOption.isEnabled()) {
                    JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                    executor.executeScript("arguments[0].click();", paymentModeSelectOption);
                }
            } catch (TimeoutException e) {
                fail("payment mode select option does not exist so we got a problem");
            }

            //Pass number for mtn payment
            By phoneNumberInputLocator = By.id("phoneNumber");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberInputLocator));
                WebElement phoneNumberInput = WebDriverFactory.getDriver().findElement(phoneNumberInputLocator);
                if (phoneNumberInput.isDisplayed() && phoneNumberInput.isEnabled()) {
                    phoneNumberInput.sendKeys("680670670");
                }
            } catch (TimeoutException e) {
                fail("phone number field does not exist so we got a problem");
            }

            //Pass customerReference for mtn payment
            By customerReferenceInputLocator = By.id("customerReference");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(customerReferenceInputLocator));
                WebElement customerReferenceInput = WebDriverFactory.getDriver().findElement(customerReferenceInputLocator);
                if (customerReferenceInput.isDisplayed() && customerReferenceInput.isEnabled()) {
                    customerReferenceInput.sendKeys("1");
                }
            } catch (TimeoutException e) {
                fail("customer reference field does not exist so we got a problem");
            }

            //Get btn to valid order
            By validOrderAndShowModalConfirmBtnLocator = By.className("add-elt-btn");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(validOrderAndShowModalConfirmBtnLocator));
                WebElement validOrderAndShowModalConfirmBtn = WebDriverFactory.getDriver().findElement(validOrderAndShowModalConfirmBtnLocator);
                if (validOrderAndShowModalConfirmBtn.isDisplayed() && validOrderAndShowModalConfirmBtn.isEnabled()) {
                    validOrderAndShowModalConfirmBtn.click();
                }
            } catch (TimeoutException e) {
                fail("valid order btn does not exist so we got a problem");
            }

            //Get btn to submit request for payment
            By submitPaymentRequestBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-dialog-confirm-payment/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(submitPaymentRequestBtnLocator));
                WebElement submitPaymentRequestBtn = WebDriverFactory.getDriver().findElement(submitPaymentRequestBtnLocator);
                if (submitPaymentRequestBtn.isDisplayed() && submitPaymentRequestBtn.isEnabled()) {
                    submitPaymentRequestBtn.click();
                }
            } catch (TimeoutException e) {
                fail("submit payment request btn does not exist so we got a problem");
            }

            /***** Check if all pass fine *****/
            //for that we should have entries in this page, if we don't have entries, we got problems
            By orderListLocator = By.className("list-elt");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListLocator));
                List<WebElement> orderLists = WebDriverFactory.getDriver().findElements(orderListLocator);
                System.out.println("leng: " + orderLists.size());
                if (orderLists.size() > 5) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }

            } catch (TimeoutException e) {
                fail("All process of order pass but the payment got problems so we cannot validated this feature");
            }
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }
}
