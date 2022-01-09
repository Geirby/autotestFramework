package com.generaltest.base;

import com.generaltest.utils.WaitForHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    public void gotoURL(String url) {
        driver.get(url);
    }

    public void waitForElementToAppear(WebElement elementLocation) {
        new WaitForHelper(driver).elementIsClickable(elementLocation);
    }

    public void waitForTime() {
        new WaitForHelper(driver).implicitwait();
    }
}
