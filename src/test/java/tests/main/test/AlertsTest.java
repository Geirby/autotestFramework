package tests.main.test;

import com.framework.base.BaseTest;
import com.framework.context.WebDriverContext;
import com.framework.enums.DemoQaElements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.main.pages.AlertsPage;
import tests.main.pages.BaseToolsPage;

public class AlertsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(AlertsTest.class.getName());
    public static final String TEST = "test";
    public static final int WAITING_TIME = 5000;

    @Test
    public void alertsTest (){
        log.info("Alerts test was start");
        AlertsPage alertsPage = new AlertsPage();
        BaseToolsPage baseToolsPage = new BaseToolsPage();
        baseToolsPage.openElement(DemoQaElements.ALERTS);
        alertsPage.clickOnAlertButton();
        Assert.assertTrue(WebDriverContext.isAlertExist());
        WebDriverContext.acceptAlert();
        alertsPage.clickOnTimerAlertButton();
        WebDriverContext.waitAlert(WAITING_TIME);
        WebDriverContext.acceptAlert();
        alertsPage.clickOnConfirmButton();
        WebDriverContext.acceptAlert();
        Assert.assertTrue(alertsPage.confirmResultIsDisplayed(),"Confirm status was not display");
        alertsPage.clickAndSendKeysOnPromtButton(TEST);
        WebDriverContext.acceptAlert();
        Assert.assertTrue(alertsPage.isPromtContainsEnteredText(TEST),"Entered text is not displayed");
    }
}
