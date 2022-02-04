package com.framework.base;


import com.framework.context.WebDriverContext;
import com.framework.utils.ConfigProperties;
import com.framework.utils.JsonParse;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeClass
    protected void setupDriver() {
        WebDriverContext.setDriver();
        WebDriverContext.getDriver().manage().window().maximize();
        WebDriverContext.getDriver().get(JsonParse.getPropertyFromJson("mainPage"));
    }

    @AfterClass
    protected void tearDown() {
        WebDriverContext.quiteDriver();
        WebDriverContext.removeDriver();
    }
}


