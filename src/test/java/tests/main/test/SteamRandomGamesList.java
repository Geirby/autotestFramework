package tests.main.test;

import com.framework.base.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.main.entity.GameObject;
import tests.main.pages.GamePage;
import tests.main.pages.SteamMainPage;

public class SteamRandomGamesList extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SteamRandomGamesList.class.getName());

    @Test
    public void steamRandomGamesList() {

        log.info("(Steam Random Games List) Test was start");
        SteamMainPage steamMainPage = new SteamMainPage();
        GamePage gamesPage = new GamePage();
        steamMainPage.hoverOverCategoriesPullDown();
        steamMainPage.clickOnRandomGenre();
        GameObject parametersFromList = steamMainPage.getGamesParametersFromList();
        steamMainPage.enterGameNameInSearch(parametersFromList.getName());
        steamMainPage.moveOnFirstGameInSearch();
        GameObject parametersFromSearch = steamMainPage.getGamesParametersFromSearch();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(parametersFromList.getName(),(parametersFromSearch.getName()),"verify games name (list and search)");
        softAssert.assertEquals(parametersFromList.getPrice(),parametersFromSearch.getPrice(),"verify games price (list and search)");
        steamMainPage.clickOnFirstGameInSearch();
        GameObject parametersFromGameCard = gamesPage.getGamesParametersFromGameCard();
        softAssert.assertEquals(parametersFromGameCard.getName(),parametersFromList.getName(),"verify games name (card and list)");
        softAssert.assertEquals(parametersFromGameCard.getPrice(),parametersFromList.getPrice(),"verify games price (card and list)");
        softAssert.assertEquals(parametersFromGameCard.getDiscount(),parametersFromList.getDiscount(),"verify games discount (card and list)");
    }
}
