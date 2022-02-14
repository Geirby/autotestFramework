package com.framework.context;


import com.framework.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;

public class WebDriverContext {

    private static final InheritableThreadLocal<WebDriver> driverInstance = new InheritableThreadLocal<>();

    enum browsers {
        CHROME,
        FIREFOX
    }

    public static void setDriver() {
        browsers actualBrowser;
        actualBrowser = browsers.valueOf(ConfigProperties.getProperty("actualBrowser"));
        switch (actualBrowser) {
            case FIREFOX -> {
                driverInstance.set(new BrowserFactory().createFireFoxDriver());
            }
            case CHROME -> {
                driverInstance.set(new BrowserFactory().createChromeDriver());
            }
            default -> throw new RuntimeException("Enter actual browser");
        }
    }

    public static void removeDriver() {
        driverInstance.remove();
    }

    public static WebDriver getDriver() {
        return driverInstance.get();
    }

    public static void quiteDriver() {
        driverInstance.get().quit();
    }
}

