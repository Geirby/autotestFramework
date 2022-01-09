package tests.tests;

import com.generaltest.base.BaseTest;
import com.generaltest.context.WebDriverContext;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.generaltest.pages.SearchPage;

import java.util.Locale;

public class YandexTest extends BaseTest {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"java"}, {"selenium"}};
    }

    @Test(dataProvider = "data-provider")
    public void searchTest(String val) {
        SearchPage searchPage = new SearchPage(WebDriverContext.getDriver());
        searchPage.openPage();
        searchPage.enterTextOnSearchField(val);
        searchPage.waitForTime();
        Assert.assertTrue(searchPage.getPageTitle().contains(val), "Title is wrong");
        Assert.assertTrue(searchPage.getTextFromSearchFieldAfterReq().toLowerCase(Locale.ROOT).contains(val), "Search parameter is wrong");
        Assert.assertTrue(searchPage.getFirstSearchResult().toLowerCase(Locale.ROOT).contains(val), "Search result is wrong");
    }

}