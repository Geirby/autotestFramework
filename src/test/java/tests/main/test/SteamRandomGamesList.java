package tests.main.test;

import com.framework.base.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        steamMainPage.clickOnRandomGame();
        GameObject randomGame = gamesPage.getGamesParameters();
        steamMainPage.enterGameNameInSearch(randomGame.getName());
        steamMainPage.clickOnFirstGameInList();
        GameObject gameFromSearch = gamesPage.getGamesParameters();
        Assert.assertEquals(randomGame, gameFromSearch);
    }
}
