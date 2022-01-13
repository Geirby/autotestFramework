package com.generaltest.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BaseElements {
    protected WebDriver driver;

    public BaseElements(WebDriver driver) {
        this.driver = driver;
    }

    public BaseElements() {

    }

    public void click(WebElement elementLocation) {
        elementLocation.click();
    }

    public void writeText(WebElement elementLocation, String text) {
        elementLocation.clear();
        elementLocation.sendKeys(text);
    }

    public String readText(WebElement elementLocation) {
        return elementLocation.getText();
    }

    public void moveToElement(WebElement elementLocation) {
        new Actions(driver).moveToElement(elementLocation).build().perform();
    }

    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public ArrayList<String> getTextFromList(List<WebElement> elementList) {
        ArrayList<String> textFromResult = new ArrayList<String>();
        for(WebElement w: elementList){
            textFromResult.add( w.getText());
        }
        return textFromResult;
    }
}
