package com.framework.context;

import com.framework.utils.ConfigProperties;
import com.framework.utils.WaitForHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverContext {

    private static final InheritableThreadLocal<WebDriver> driverInstance = new InheritableThreadLocal<>();

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

    public static Alert waitAlert(final long time) {
        return new WebDriverWait(driverInstance.get(), time, 200).until(new ExpectedCondition<Alert>() {
            @Override
            public Alert apply(WebDriver d) {
                Alert alert = d.switchTo().alert();
                if (alert != null) {
                    return alert;
                } else {
                    return null;
                }
            }
        });
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
}

