package com.generaltest.tests;

import com.generaltest.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.generaltest.pages.SearchPage;

import java.util.Locale;

public class YandexTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    public void beforeTest() {
        setupDriver();
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchTest() {

        String firstValue = "java";
        String secondValue = "selenium";

        searchPage.openPage();
        searchPage.enterTextOnSearchField(firstValue);
        searchPage.waitForTime();
        Assert.assertTrue(searchPage.getPageTitle().contains(firstValue), "Title is wrong");
        Assert.assertTrue(searchPage.getTextFromSearchFieldAfterReq().toLowerCase(Locale.ROOT).contains(firstValue), "Search parameter is wrong");
        Assert.assertTrue(searchPage.getFirstSearchResult().toLowerCase(Locale.ROOT).contains(firstValue), "Search result is wrong");
        searchPage.enterTextOnSearchFieldAfterReq(secondValue);
        Assert.assertTrue(searchPage.getPageTitle().contains(secondValue), "Title is wrong");
        Assert.assertTrue(searchPage.getTextFromSearchFieldAfterReq().toLowerCase(Locale.ROOT).contains(secondValue), "Search parameter is wrong");
        Assert.assertTrue(searchPage.getFirstSearchResult().toLowerCase(Locale.ROOT).contains(secondValue), "Search result is wrong");
    }

    @AfterClass
    @Override
    protected void tearDown() {
        driver.quit();
    }
}
