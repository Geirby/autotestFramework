package com.framework.context;

import com.framework.utils.ConfigProperties;
import com.framework.utils.WaitForHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.main.test.AlertsTest;

import java.util.ArrayList;

public class WebDriverContext {

    private static final Logger log = LoggerFactory.getLogger(WebDriverContext.class.getName());
    private static final InheritableThreadLocal<WebDriver> driverInstance = new InheritableThreadLocal<>();
    public static final int SLEEP_IN_MILLIS = 200;

    enum Browsers {
        CHROME,
        FIREFOX
    }

    public static void setDriver() {
        driverInstance.set(BrowserFactory.createWebDriver(Browsers.valueOf(ConfigProperties.getProperty("actualBrowser"))));
    }

    public static void removeDriver() {
        driverInstance.remove();
    }

    public static void closeTab() {
        driverInstance.get().close();
    }

    public static WebDriver getDriver() {
        if (driverInstance.get() == null) {
            setDriver();
            return driverInstance.get();
        }
        return driverInstance.get();
    }

    public static void quiteDriver() {
        driverInstance.get().quit();
    }

    public static void implicitWait() {
        new WaitForHelper(driverInstance.get()).implicitWait();

    }

    public static void acceptAlert() {
        driverInstance.get().switchTo().alert().accept();
    }

    public static void waitAlert(final long time) {
        new WebDriverWait(driverInstance.get(), time, SLEEP_IN_MILLIS).until(new ExpectedCondition<Alert>() {
            @Override
            public Alert apply(WebDriver d) {
                return d.switchTo().alert();
            }
        });
    }

    public static Boolean isAlertExist() {
        try {
            WebDriverWait wait = new WebDriverWait(driverInstance.get(), SLEEP_IN_MILLIS);
            wait.until(ExpectedConditions.alertIsPresent());
            log.info("Alert is Exist");
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void dismissAlert() {
        driverInstance.get().switchTo().alert().dismiss();
    }

    public static void getTextFromAlert() {
        driverInstance.get().switchTo().alert().getText();
    }

    public static void sendKeysAlert(String keys) {
        driverInstance.get().switchTo().alert().sendKeys(keys);
    }

    public static void switchToIframe(WebElement webElement) {
        driverInstance.get().switchTo().frame(webElement);
    }

    public static void switchToTab(String handleOfTab) {
        driverInstance.get().switchTo().window(handleOfTab);
    }

    public static void switchToParentTab() {
        driverInstance.get().switchTo().window(WebDriverContext.getHandle(0));
    }

    public static String getHandle(Integer numberOfHandle) {
        ArrayList<String> listOfHandle = new ArrayList<String>(driverInstance.get().getWindowHandles());
        return listOfHandle.get(numberOfHandle);
    }
}

