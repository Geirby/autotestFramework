package tests.main.test;

import com.framework.base.BaseTest;
import com.framework.context.WebDriverContext;
import com.framework.enums.DemoQaElements;
import com.framework.utils.JsonParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.main.pages.BaseToolsPage;
import tests.main.pages.BrowserWindowsPage;

public class BrowserWindowsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BrowserWindowsTest.class.getName());
    BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
    BaseToolsPage baseToolsPage = new BaseToolsPage();

    @Test
    public void clickAndSwitchToTabButton() {
        log.info("browser windows test was start");
        baseToolsPage.openElement(DemoQaElements.BROWSER_WINDOWS);
        browserWindowsPage.clickAndSwitchToTabButton();
        Assert.assertEquals(browserWindowsPage.getTextFromSampleHeading(), JsonParse.getPropertyFromJson("text"), "Browser window new tab message");
        WebDriverContext.closeTab();
    }

    @Test(priority = 1)
    public void clickAndSwitchToWindowButton() {
        WebDriverContext.switchToParentTab();
        browserWindowsPage.clickAndSwitchToWindowButton();
        Assert.assertEquals(browserWindowsPage.getTextFromSampleHeading(), JsonParse.getPropertyFromJson("text"), "Browser window new tab message");
        WebDriverContext.closeTab();
    }

    @Test(priority = 2)
    public void clickAndSwitchToMessageWindowButton() {
        WebDriverContext.switchToParentTab();
        browserWindowsPage.clickAndSwitchToMessageWindowButton();
        Assert.assertEquals(browserWindowsPage.getTextFromBody(), JsonParse.getPropertyFromJson("message"), "Browser window new tab message");
    }
}
