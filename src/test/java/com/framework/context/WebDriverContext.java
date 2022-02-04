package com.framework.context;


import com.framework.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                WebDriverManager.firefoxdriver().setup();
                driverInstance.set(new FirefoxDriver());
            }
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driverInstance.set(new ChromeDriver());
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

