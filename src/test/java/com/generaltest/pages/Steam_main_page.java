package com.generaltest.pages;

import com.generaltest.base.BaseElements;
import com.generaltest.base.BasePage;
import com.generaltest.context.WebDriverContext;
import com.generaltest.utils.ConfigProperties;
import io.netty.util.internal.logging.CommonsLoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Steam_main_page extends BasePage {

    BaseElements baseElements = new BaseElements();

    public Steam_main_page() {
        WebDriverContext.getDriver().get("https://store.steampowered.com/");
    }


    @FindBy(xpath = "//*[@class = 'global_action_link']")
    private WebElement logInLink;

    @FindBy(id = "input_username")
    private WebElement userNameInputField;

    @FindBy(id = "input_password")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@class = 'btn_blue_steamui btn_medium login_btn']")
    private WebElement loginBtn;

    @FindBy(id = "error_display")
    private WebElement errorWindow;

    public void openLoginForm(){
        baseElements.click(logInLink);
    }

    public void enterWrongCredentials(){
        baseElements.enterText(userNameInputField, ConfigProperties.getProperty("validSteamEmail"));
        baseElements.enterText(passwordInputField, ConfigProperties.getProperty("wrongSteamPassword"));
    }

    public void clickOnLogInBtn(){
        baseElements.click(loginBtn);
    }

    public void errorWindowIsDisplayed(){
        waitForElementToAppear(errorWindow);
    }


}




