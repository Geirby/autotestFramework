package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import com.framework.utils.JsonParse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BasePage {

    @FindBy(id = "timerAlertButton")
    private BrowserElements timerAlertButton;

    @FindBy(id = "alertButton")
    private BrowserElements alertButton;

    @FindBy(id = "confirmButton")
    private BrowserElements confirmButton;

    @FindBy(id = "confirmResult")
    private BrowserElements confirmResult;

    @FindBy(id = "promtButton")
    private BrowserElements promtButton;

    @FindBy(id = "promptResult")
    private BrowserElements promptResult;

    public AlertsPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    public void openAlertsPage() {
        WebDriverContext.getDriver().get((JsonParse.getPropertyFromJson("alertsPage")));
    }

    public void clickOnTimerAlertButton() {
        timerAlertButton.click();
    }

    public void clickOnAlertButton() {
        alertButton.click();
    }

    public void clickOnConfirmButton() {
        confirmButton.click();
    }

    public boolean confirmResultIsDisplayed() {
        return confirmResult.isExist();
    }

    public void clickAndSendKeysOnPromtButton(String value) {
        promtButton.click();
        WebDriverContext.sendKeysAlert(value);
    }

    public boolean isPromtContainsEnteredText(String neededText) {
       return promptResult.getText().contains(neededText);
    }
}
