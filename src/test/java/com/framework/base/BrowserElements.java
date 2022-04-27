package com.framework.base;

import com.framework.context.WebDriverContext;
import com.framework.utils.WaitForHelper;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BrowserElements {

    private static final Logger log = LoggerFactory.getLogger(BrowserElements.class.getName());
    protected WebDriver driver = WebDriverContext.getDriver();
    protected WebElement webElement;


    public BrowserElements(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
        //log.info(webElement.toString() + " was click");
    }

    public void enterText(String text) {
        webElement.clear();
        webElement.sendKeys(text);
        log.info(text + " was enter " + webElement.toString());
    }

    public String getText() {
        log.info(webElement.getText() + " get text from " + webElement.toString());
        return webElement.getText();
    }

    public void moveToElement() {
        new Actions(driver).moveToElement(webElement).build().perform();
        log.info("moved to " + webElement.toString());
    }

    public void pressEnter() {
        webElement.sendKeys(Keys.ENTER);
        log.info("pressed enter om " + webElement.toString());
    }

    public ArrayList<String> getTextFromList(List<WebElement> elementList) {
        ArrayList<String> textFromResult = new ArrayList<String>();
        for (WebElement element : elementList) {
            textFromResult.add(element.getText());
        }
        log.info("text from list was take" + webElement.toString());
        return textFromResult;
    }

    public void waitForElementIsClickable() {
        new WaitForHelper(driver).elementIsClickable(webElement);
        log.info("element became clickable " + webElement.toString());
    }

    public void waitForElementIsInvisible() {
        new WaitForHelper(driver).elementIsAppeared(webElement);
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void moveSliderToValue(int maxValue, int value) {
        double elementLocationX = webElement.getLocation().x;
        double elementWidth = webElement.getSize().width * 0.965;
        double elementLocationXAfterValue = (elementWidth / maxValue) * value;
        log.info(String.valueOf(elementLocationX));
        log.info(String.valueOf(elementWidth));
        Actions action = new Actions(driver);
        log.info(String.valueOf(elementLocationXAfterValue));
        action.dragAndDropBy(webElement, (int)(elementLocationXAfterValue - (elementWidth/2)), 0).perform();
    }


}
