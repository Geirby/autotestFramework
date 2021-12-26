package com.generaltest.base;

import com.generaltest.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasPage {
    protected WebDriver driver;

    public void BasePage (WebDriver driver){
        this.driver = driver;
    }

    public void gotoURL(String url) {
        driver.get(url);
    }

    public void waitForElementToAppear(By elementLocation) {
        new WaitForHelper(driver).presenceOfTheElement(elementLocation);
    }

    public void waitForTime() {
        new WaitForHelper(driver).implicitwait( );
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click( );
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).clear( );
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText( );
    }

    public void moveToElement(By elementLocation) {
        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build( ).perform( );
    }
}
