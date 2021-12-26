package com.generaltest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitwait()
    {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigProperties.getProperty("elementLoadTimeout")), TimeUnit.SECONDS);
    }


    public WebElement presenceOfTheElement(final WebElement elementIdentifier) {
        WebElement firstResult = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return firstResult;
    }
}
