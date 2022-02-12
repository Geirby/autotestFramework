package tests.main.test;

import com.framework.base.BaseTest;
import com.framework.utils.Log;
import tests.main.pages.SteamMainPage;
import org.testng.annotations.Test;

public class SteamTestInvalidLogin extends BaseTest {



    @Test
    public void steamTestInvalidLogin() {
        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.openLoginForm();
        steamMainPage.enterWrongCredentials();
        steamMainPage.clickOnLogInBtn();
        steamMainPage.waitErrorWindow();
        steamMainPage.errorWindowIsDisplayed();
        Log.info("steamTestInvalidLogin");
    }


}
