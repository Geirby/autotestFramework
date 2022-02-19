package com.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigProperties.getProperty("elementLoadTimeout")), TimeUnit.SECONDS);
    }

    public void elementIsClickable(final WebElement elementIdentifier) {
        try {
            WebElement firstResult = new WebDriverWait(driver, Integer.parseInt(ConfigProperties.getProperty("elementLoadTimeout")))
                    .until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        } catch (Exception e) {
            throw new RuntimeException("Element" + elementIdentifier.toString() + " not found");
        }
    }

    public void listOfElementsAreVisible(final List<WebElement> listOfElements) {
        try {
            List<WebElement> list = new WebDriverWait(driver, Integer.parseInt(ConfigProperties.getProperty("elementLoadTimeout")))
                    .until(ExpectedConditions.visibilityOfAllElements(listOfElements));
        } catch (Exception e) {
            throw new RuntimeException("List of Elements" + listOfElements.toString() + " not found");
        }
    }

    public void elementIsAppeared(final WebElement element) {
        try {
            boolean webElement = new WebDriverWait(driver, Integer.parseInt(ConfigProperties.getProperty("elementLoadTimeout")))
                    .until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            throw new RuntimeException("Element" + element.toString() + " not found");
        }
    }
}



