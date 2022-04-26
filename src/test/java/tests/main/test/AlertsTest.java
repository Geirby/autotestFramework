package tests.main.test;

import com.framework.context.WebDriverContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import tests.main.pages.AlertsPage;

public class AlertsTest {

    private static final Logger log = LoggerFactory.getLogger(SendMailTest.class.getName());
    public static final String TEST = "test";

    @Test
    public void alertsTest (){
        log.info("Alerts test was start");
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.openAlertsPage();
        alertsPage.clickOnAlertButton();
        WebDriverContext.acceptAlert();
        alertsPage.clickOnTimerAlertButton();
        WebDriverContext.waitAlert(5000);
        WebDriverContext.acceptAlert();
        SoftAssert softAssert = new SoftAssert();
        alertsPage.clickOnConfirmButton();
        WebDriverContext.acceptAlert();
        softAssert.assertTrue(alertsPage.confirmResultIsDisplayed(),"status was change");
        alertsPage.clickOnPromtButton();
        WebDriverContext.sendKeysAlert(TEST);
        WebDriverContext.acceptAlert();
        softAssert.assertEquals(alertsPage.getTextFromPromtResult(),TEST,"promt result is correct");
    }
}
