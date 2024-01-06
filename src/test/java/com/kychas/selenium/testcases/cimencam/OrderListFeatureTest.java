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

public class OrderListFeatureTest extends BaseTest {

    public OrderListFeatureTest() {
        super();
    }

    @Test
    public void testDetailOrderFromOrderMenu() {
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
            TimeUtils.waitForSeconds(2);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[5]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

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

            TimeUtils.waitForSeconds(2);
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(0).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(0).click();
            }
        } catch (Exception e) {
            fail("We cannot view order");
        }
    }

    @Test
    public void testDetailRemovalFromOrderMenu() {
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
            TimeUtils.waitForSeconds(2);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[5]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

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

            TimeUtils.waitForSeconds(2);
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(1).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(1).click();
            }
        } catch (Exception e) {
            fail("We cannot view order");
        }
    }

    @Test
    public void testDetailOrderFromOrderMenuInsufficientAccount() {
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

            TimeUtils.waitForSeconds(2);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[5]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

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
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(0).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(0).click();
            }
        } catch (Exception e) {
            fail("We cannot view order");
        }
    }

    @Test
    public void testValidateOrderFromOrderMenuInsufficientAccountWithValidateBtn() {
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
            TimeUtils.waitForSeconds(2);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[5]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

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
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(1).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(1).click();
            }
            TimeUtils.waitForSeconds(2);

            By validatedBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-dialog-low-balance-validated-order/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(validatedBtnLocator));
                WebElement validatedBtn = WebDriverFactory.getDriver().findElement(validatedBtnLocator);
                if (validatedBtn.isEnabled() && validatedBtn.isDisplayed()) {
                    validatedBtn.click();
                    TimeUtils.waitForSeconds(2);
                }
            } catch (TimeoutException e) {
                fail("Annulation de la validation de la commande au solde insuffisant non fonctionnel");
            }

            TimeUtils.waitForSeconds(5);

            System.out.println("size before : " + elementOrderLists.size());

            TimeUtils.waitForSeconds(3);
            // view detail of order
            By elementListOrder1Locator = By.className("list-elt");
            List<WebElement> elementOrder1Lists = WebDriverFactory.getDriver().findElements(elementListOrder1Locator);
            System.out.println("size after : " + elementOrder1Lists.size());
        } catch (Exception e) {
            fail("We cannot view order menu, it sound like we didn't log in");
        }
    }

    @Test
    public void testValidateOrderFromOrderMenuInsufficientAccountWithCancelBtn() {
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

            TimeUtils.waitForSeconds(2);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[5]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

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
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(1).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                btnOrderLists.get(1).click();
            }

            TimeUtils.waitForSeconds(2);
            By cancelBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-dialog-low-balance-validated-order/nb-card/nb-card-footer/button[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelBtnLocator));
                WebElement cancelBtn = WebDriverFactory.getDriver().findElement(cancelBtnLocator);
                if (cancelBtn.isEnabled() && cancelBtn.isDisplayed()) {
                    cancelBtn.click();
                }
            } catch (TimeoutException e) {
                fail("Annulation de la validation de la commande au solde insuffisant non fonctionnel");
            }

            By inputFieldLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[2]/div/nb-dialog-container/nb-card/nb-card-body/div/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(inputFieldLocator));
                WebElement inputField = WebDriverFactory.getDriver().findElement(inputFieldLocator);
                inputField.sendKeys("Test de l'application");
            } catch (TimeoutException e) {
                fail("Annulation de la validation de la commande au solde insuffisant non fonctionnel");
            }

            TimeUtils.waitForSeconds(2);
            By rejectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[2]/div/nb-dialog-container/nb-card/nb-card-footer/button");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(rejectLocator));
                WebElement reject = WebDriverFactory.getDriver().findElement(rejectLocator);
                if (reject.isEnabled() && reject.isDisplayed()) {
                    reject.click();
                }
            } catch (TimeoutException e) {
                fail("Annulation de la validation de la commande au solde insuffisant non fonctionnel");
            }
        } catch (Exception e) {
            fail("We cannot view order menu, it sound like we didn't log in");
        }
    }
}
