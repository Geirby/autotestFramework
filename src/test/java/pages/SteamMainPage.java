package pages;

import com.framework.base.BaseElements;
import com.framework.base.BasePage;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import com.framework.utils.JsonParse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SteamMainPage extends BasePage {

    public SteamMainPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    static String [] gameGenres= {"Action", "Role-Playing", "Strategy", "Adventure & Casual", "Simulation", "Sports & Racing"};
    static int randomNumber = (int)Math.floor(Math.random() * gameGenres.length);
    static final String randomGenre = gameGenres[randomNumber];

    @FindBy(xpath = "//*[@class = 'global_action_link']")
    private BaseElements logInLink;

    @FindBy(id = "input_username")
    private BaseElements userNameInputField;

    @FindBy(id = "input_password")
    private BaseElements passwordInputField;

    @FindBy(xpath = "//*[@class = 'btn_blue_steamui btn_medium login_btn']")
    private BaseElements loginButton;

    @FindBy(id = "error_display")
    private BaseElements errorWindow;

    @FindBy(className = "header_installsteam_btn_content")
    private BaseElements installSteamButton;

    @FindBy(className = "about_install_steam_link")
    private BaseElements downLoadSteamButton;

    @FindBy(xpath = "//*[@id=\"genre_tab\"]/span/a[1]")
    private BaseElements categoriesPullDown;

    @FindBy(xpath = "//*[@id=\"genre_flyout\"]/div/div[2]/div[3]/a")
    private BaseElements randomGameGenre;

    @FindBy(xpath = "//*[@id=\"SaleSection_71167\"]/div/div[2]/div[1]/div[1]/div/div/a/div[2]/img")
    private BaseElements firstGame;



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
        categoriesPullDown.implicitWait();
    }

    public void chooseGenre() {
        randomGameGenre.click();
    }

    public void clickOnGame(){
        firstGame.click();
    }
}




