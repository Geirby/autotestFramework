package com.generaltest.pages;

import com.generaltest.base.BasePage;
import com.generaltest.utils.ConfigProperties;
import com.generaltest.utils.WaitForHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.generaltest.base.BaseElements;

public class SearchPage extends BasePage {

    BaseElements baseElements = new BaseElements();

    public SearchPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    String webpage = ConfigProperties.getProperty("webpage");

    @FindBy(id = "text")
    private WebElement searchField;

    @FindBy(className = "OrganicTitleContentSpan")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//head/title/text()")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@class=\"input__control mini-suggest__input\"] ")
    private WebElement searchFieldAfterReq;

    @FindBy(xpath ="//span/span/span" )
    private WebElement clearIcon;


    public String enterValue(String value) {
        return value;
    }

    public void openPage(){
        gotoURL(webpage);
        waitForElementToAppear(searchField);
    }

    public void enterTextOnSearchField(String value) {
        baseElements.writeText(searchField,value);
        baseElements.pressEnter(searchField);
    }

    public void enterTextOnSearchFieldAfterReq(String value) {
        baseElements.writeText(searchFieldAfterReq,value);
        baseElements.pressEnter(searchFieldAfterReq);
    }

    public String getFirstSearchResult() {
        return firstSearchResult.getText();
    }

    public String getTextFromSearchFieldAfterReq() {
        return searchFieldAfterReq.getAttribute("value");
    }

    public WebElement getClearIcon(){
        return getClearIcon();
    }

    public WebElement getSearchFieldAfterReq(){
        return searchFieldAfterReq;
    }

    public void waitTime(){
        waitForTime();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}



