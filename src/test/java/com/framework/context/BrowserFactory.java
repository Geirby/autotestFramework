package com.framework.context;

import com.framework.utils.JsonParse;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    public final static String DOWNLOAD_DEFAULT_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\download\\";

    private static WebDriver createFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
       // options.setBinary(JsonParse.getPropertyFromJson("pathForDefaultDownloadFolder"));
        FirefoxDriver firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.manage().window().maximize();
        return firefoxDriver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<String, Object>();
        //prefs.put("download.default_directory", DOWNLOAD_DEFAULT_PATH);
        //prefs.put("safebrowsing.enabled", "true");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        //options.addArguments("disable-popup-blocking");
        return new ChromeDriver(options);
    }

    public static WebDriver createWebDriver(final WebDriverContext.Browsers type) {
        return switch (type) {
            case CHROME -> createChromeDriver();
            case FIREFOX -> createFireFoxDriver();
        };
    }
}