package tests.main.pages;

import com.framework.base.BaseTest;
import com.framework.base.BrowserElements;
import com.framework.base.BasePage;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import com.framework.utils.JsonParse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tests.main.entity.GameObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SteamMainPage extends BasePage {

    public SteamMainPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    @FindBy(className = "global_action_link")
    private BrowserElements logInLink;

    @FindBy(id = "input_username")
    private BrowserElements userNameInputField;

    @FindBy(id = "input_password")
    private BrowserElements passwordInputField;

    @FindBy(xpath = "//*[@class = 'btn_blue_steamui btn_medium login_btn']")
    private BrowserElements loginButton;

    @FindBy(id = "error_display")
    private BrowserElements errorWindow;

    @FindBy(className = "header_installsteam_btn_content")
    private BrowserElements installSteamButton;

    @FindBy(className = "about_install_steam_link")
    private BrowserElements downLoadSteamButton;

    @FindBy(xpath = "//*[@id=\"genre_tab\"]/span/a[1]")
    private BrowserElements categoriesPullDown;

    @FindBy(xpath = "//*[@id=\"genre_flyout\"]/div/div[2]/div/a")
    private List<BrowserElements> firstPartOfGenreList;

    @FindBy(xpath = "//*[@id=\"genre_flyout\"]/div/div[3]/div/a")
    private List<BrowserElements> secondPartOfGenreList;

    @FindBy(xpath = "//*[@id=\"genre_flyout\"]/div/div[4]/div/a")
    private List<BrowserElements> thirdPartOfGenreList;

    @FindBy(xpath = "//*[@id=\"genre_flyout\"]/div/div[2]/div[6]")
    private BrowserElements oneOfGenre;

    @FindBy(xpath = "//*[@id=\"NewReleasesRows\"]/a")
    private List<BrowserElements> listOfGames;

    @FindBy(id = "store_nav_search_term")
    private BrowserElements searchInput;

    @FindBy(xpath = "//*[@id=\"view_product_page_btn\"]/span")
    private BrowserElements skippAgeValidationDialogButton;

    @FindBy(id = "ageYear")
    private WebElement ageSelectList;

    @FindBy(xpath = "//*[@id=\"search_suggestion_contents\"]/a[1]")
    private BrowserElements firstGameInList;


    public void openLoginForm() {
        logInLink.click();
    }

    public void enterWrongCredentials() {
        userNameInputField.enterText(JsonParse.getPropertyFromJson("invalidEmail"));
        passwordInputField.enterText(JsonParse.getPropertyFromJson("invalidPassword"));
    }

    public void clickOnLogInBtn() {
        loginButton.click();
    }

    public void errorWindowIsDisplayed() {
        errorWindow.waitForElementIsClickable();
    }

    public void clickOnInstallSteamButton() {
        installSteamButton.click();
    }

    public void downLoadSteamApp() throws IOException {
        downLoadSteamButton.downloadFile(JsonParse.getPropertyFromJson("pathForDownloadedFiles"));
    }

    public void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    public void waitErrorWindow() {
        errorWindow.implicitWait();
    }

    public void hoverOverCategoriesPullDown() {
        categoriesPullDown.moveToElement();
        oneOfGenre.waitForElementIsClickable();
    }

    public void clickOnRandomGenre() {
        List<BrowserElements> allGenres = new ArrayList<>();
        allGenres.addAll(firstPartOfGenreList);
        allGenres.addAll(secondPartOfGenreList);
        allGenres.addAll(thirdPartOfGenreList);
        Random random = new Random();
        BrowserElements randomGameGenre = allGenres.get(random.nextInt(allGenres.size()));
        randomGameGenre.click();
    }

    public void clickOnRandomGame() {
        Random random = new Random();
        BrowserElements randomGame = listOfGames.get(random.nextInt(listOfGames.size()));
        randomGame.click();
    }

    public void enterGamesNameInSearch(String gamesName) {
        //validationAgeChecker();
        searchInput.enterText(gamesName);
        searchInput.click();
        firstGameInList.waitForElementIsClickable();
    }

    public void selectValidYear() {
        Select select = new Select(ageSelectList);
        select.selectByValue("2000");
    }

    public void validationAgeChecker() {
        if (ageSelectList.isDisplayed()) {
            selectValidYear();
            skippAgeValidationDialogButton.click();
        } else {
            System.out.println("Game without validation");
        }
    }

    public void clickOnFirstGameInList() {
        firstGameInList.click();
    }
}




