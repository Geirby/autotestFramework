package tests.main.test;

import com.framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.main.entity.GameObject;
import tests.main.pages.GamePage;
import tests.main.pages.SteamMainPage;

public class SteamRandomGamesList extends BaseTest {




    @Test
    public void steamRandomGamesList() {

        SteamMainPage steamMainPage = new SteamMainPage();
        GamePage gamesPage = new GamePage();
        steamMainPage.hoverOverCategoriesPullDown();
        steamMainPage.clickOnRandomGenre();
        steamMainPage.clickOnRandomGame();
        GameObject randomGame = gamesPage.getGamesParameters();
        steamMainPage.enterGamesNameInSearch(randomGame.getName());
        steamMainPage.clickOnFirstGameInList();
        GameObject gameFromSearch = gamesPage.getGamesParameters();
        Assert.assertEquals(randomGame,gameFromSearch);







    }

}
