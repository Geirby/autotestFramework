package com.generaltest.base;


import com.generaltest.pages.SearchPage;
import com.generaltest.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public abstract class BaseTest {

    protected WebDriver driver;

    protected void setupDriver() {

        String browser = ConfigProperties.getProperty("actualBrowser");

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.err.println("Enter actual browser");
        }
    }

    protected abstract void tearDown();


}


