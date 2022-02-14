package tests.main.test;

import com.framework.base.BaseTest;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.main.pages.SteamMainPage;
import org.testng.annotations.Test;

public class SteamTestInvalidLogin extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SteamTestInvalidLogin.class.getName());

    @Test
    public void steamInvalidLogin() {
        log.info("(Steam Invalid Login) test was start");
        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.openLoginForm();
        steamMainPage.enterWrongCredentials();
        steamMainPage.clickOnLogInBtn();
        steamMainPage.waitErrorWindow();
        steamMainPage.errorWindowIsDisplayed();

    }


}
