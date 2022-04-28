package tests.main.test;

import com.framework.context.WebDriverContext;
import com.framework.utils.JsonParse;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.main.pages.BrowserWindowsPage;

public class BrowserWindowsTest {

    private static final Logger log = LoggerFactory.getLogger(BrowserWindowsTest.class.getName());

    @Test
    public void browserWindowsTest() {
        log.info("browser windows test was start");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.openBrowserWindowsPage();
        String parentHandle = WebDriverContext.getHandle(0);
        browserWindowsPage.clickOnTabButton();
        WebDriverContext.switchToTab(WebDriverContext.getHandle(1));
        Assert.assertEquals(browserWindowsPage.getTextFromSampleHeading(), JsonParse.getPropertyFromJson("text"), "text is the same");
        WebDriverContext.getDriver().close();
        WebDriverContext.switchToTab(parentHandle);
        browserWindowsPage.clickOnWindowButton();
        WebDriverContext.switchToTab(WebDriverContext.getHandle(1));
        Assert.assertEquals(browserWindowsPage.getTextFromSampleHeading(), JsonParse.getPropertyFromJson("text"), "text is the same");
        WebDriverContext.getDriver().close();
        WebDriverContext.switchToTab(parentHandle);
        browserWindowsPage.clickOnMessageWindowButton();
        WebDriverContext.switchToTab(WebDriverContext.getHandle(1));
        Assert.assertEquals(browserWindowsPage.getTextFromBody(), JsonParse.getPropertyFromJson("message"), "text is the same");
        WebDriverContext.getDriver().close();
        WebDriverContext.switchToTab(parentHandle);
    }
}
