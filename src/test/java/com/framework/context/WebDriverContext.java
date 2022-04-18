package com.framework.context;

import com.framework.utils.ConfigProperties;
import com.framework.utils.WaitForHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        if (driverInstance.get() == null){
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

    public static void switchToIframe (WebElement webElement) {
        driverInstance.get().switchTo().frame(webElement);
    }
}

