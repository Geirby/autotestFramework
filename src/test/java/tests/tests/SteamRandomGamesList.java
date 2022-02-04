package tests.tests;

import com.framework.base.BaseTest;
import org.testng.annotations.Test;
import pages.SteamMainPage;

import java.util.ArrayList;
import java.util.List;

public class SteamRandomGamesList extends BaseTest {




    @Test
    public void steamRandomGamesList() {
        List<Integer> prices = new ArrayList<>();
        List<Integer> sales = new ArrayList<>();
        List<String> names = new ArrayList<>();

        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.hoverOverCategoriesPullDown();
        steamMainPage.chooseGenre();
        steamMainPage.clickOnGame();



    }

}
