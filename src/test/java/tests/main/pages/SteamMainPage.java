package tests.main.pages;

import com.framework.base.BrowserElements;
import com.framework.base.BasePage;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import com.framework.utils.FileActions;
import com.framework.utils.JsonParse;
import com.framework.utils.Randomizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.main.entity.GameObject;

import java.util.ArrayList;
import java.util.List;

public class SteamMainPage extends BasePage {

    private static final String SKIPP_AGE_VALIDATE = "2000";
    private static final Logger log = LoggerFactory.getLogger(SteamMainPage.class.getName());

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
    private WebElement downLoadSteamButton;

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

    @FindBy(xpath = "//*[@id=\"NewReleasesRows\"]/a[1]/div[3]/div[1]")
    private BrowserElements firstGameNameFromList;

    @FindBy(xpath = "//*[@id=\"NewReleasesRows\"]/a[1]/div[2]/div/div")
    private BrowserElements firstGamePriceFromList;

    @FindBy(xpath = "//*[@id=\"NewReleasesRows\"]/a[1]/div[2]/div[1]")
    private BrowserElements firstGameDiscountFromList;

    @FindBy(xpath = "//*[@id=\"NewReleasesRows\"]/a")
    private List<BrowserElements> gamesList;

    @FindBy(id = "store_nav_search_term")
    private BrowserElements searchInput;

    @FindBy(xpath = "//*[@id=\"view_product_page_btn\"]/span")
    private BrowserElements skippAgeValidationDialogButton;

    @FindBy(id = "ageYear")
    private WebElement ageSelectList;

    @FindBy(xpath = "//*[@id=\"search_suggestion_contents\"]/a[1]")
    private BrowserElements firstGameFromList;

    @FindBy(xpath = "//*[@id=\"search_suggestion_contents\"]/a/div[1]")
    private BrowserElements gameNameFromSearch;

    @FindBy(xpath = "//*[@id=\"search_suggestion_contents\"]/a/div[3]")
    private BrowserElements gamePriceFromSearch;


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

    public void clickOnDownLoadButton() {
        downLoadSteamButton.click();
        FileActions.waitForDownloadUniversal(FileActions.PATH_FOR_FILE);
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
        Randomizer.chooseRandomElementFromList(allGenres).click();
    }

    public void clickOnRandomGame() {
        Randomizer.chooseRandomElementFromList(gamesList).getText();
    }

    public void enterGameNameInSearch(String gamesName) {
        validationAgeChecker();
        searchInput.enterText(gamesName);
        searchInput.click();
        firstGameFromList.waitForElementIsClickable();
    }

    public void selectValidYear() {
        Select select = new Select(ageSelectList);
        select.selectByValue(SKIPP_AGE_VALIDATE);
    }

    public void validationAgeChecker() {
        if (!WebDriverContext.getDriver().findElements(By.id("ageYear")).isEmpty()) {
            selectValidYear();
            skippAgeValidationDialogButton.click();
        } else {
            log.info("Select game don't have age validation");
        }
    }

    public void moveOnFirstGameInSearch() {
        firstGameFromList.moveToElement();
    }

    public void clickOnFirstGameInSearch() {
        firstGameFromList.click();
    }

    public GameObject getGamesParametersFromList() {
        return new GameObject(firstGameNameFromList, firstGamePriceFromList, firstGameDiscountFromList);
    }

    public GameObject getGamesParametersFromSearch() {
        return new GameObject(gameNameFromSearch, gamePriceFromSearch, null);
    }
}




