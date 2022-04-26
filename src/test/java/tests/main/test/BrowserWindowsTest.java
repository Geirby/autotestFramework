package tests.main.test;

import com.framework.context.WebDriverContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import tests.main.pages.BrowserWindowsPage;

public class BrowserWindowsTest {

    private static final Logger log = LoggerFactory.getLogger(SendMailTest.class.getName());

    @Test
    public void browserWindowsTest() {
        log.info("browser windows test was start");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.openBrowserWindowsPage();
        browserWindowsPage.clickOnTabButton();
        WebDriverContext.getListsOfHandle();
    }
}
