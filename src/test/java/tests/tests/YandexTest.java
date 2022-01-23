package tests.tests;

import com.generaltest.base.BaseTest;
import com.generaltest.context.WebDriverContext;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.generaltest.pages.SearchPage;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Locale;

public class YandexTest extends BaseTest {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"java"}, {"selenium"}};
    }

    @Test(dataProvider = "data-provider")
    public void searchTest(String value) {
        SearchPage searchPage = new SearchPage();
        searchPage.openPage();
        searchPage.enterTextOnSearchField(value);
        searchPage.waitForTime();
        Assert.assertTrue(searchPage.getPageTitle().contains(value), "Title is wrong");
        Assert.assertTrue(searchPage.getTextFromSearchFieldAfterReq().toLowerCase(Locale.ROOT).contains(value), "Search parameter is wrong");
        SoftAssert verifyResults = new SoftAssert();
        ArrayList<String> results = searchPage.getTextFromList();
        for(String r : results){
            verifyResults.assertTrue(r.toLowerCase(Locale.ROOT).contains(value), "Search parameter is wrong");
        }
        verifyResults.assertAll();
    }
}