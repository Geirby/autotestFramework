package com.generaltest.base;

import com.generaltest.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage() {
    }

    public void gotoURL(String url) {
        driver.get(url);
    }

    public void waitForElementToAppear(WebElement elementLocation) {
        new WaitForHelper(driver).presenceOfTheElement(elementLocation);
    }

    public void waitForTime() {
        new WaitForHelper(driver).implicitwait( );
    }

    public void click(WebElement elementLocation) {
        elementLocation.click();
    }

    public void writeText(WebElement elementLocation, String text) {
        elementLocation.clear( );
        elementLocation.sendKeys(text);
    }

    public String readText(WebElement elementLocation) {
        return elementLocation.getText( );
    }

    public void moveToElement(WebElement elementLocation) {
        new Actions(driver).moveToElement(elementLocation).build( ).perform( );
    }

    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }


}
