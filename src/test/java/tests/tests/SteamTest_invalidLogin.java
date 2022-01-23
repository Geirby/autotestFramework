package tests.tests;

import com.generaltest.base.BaseTest;
import com.generaltest.pages.Steam_main_page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SteamTest_invalidLogin extends BaseTest {

    Steam_main_page steam_main_page = new Steam_main_page();

    @Test
    public void steamTest_invalidLogin(){
        steam_main_page.openLoginForm();
        steam_main_page.enterWrongCredentials();
        steam_main_page.clickOnLogInBtn();
        steam_main_page.errorWindowIsDisplayed();


    }





}
