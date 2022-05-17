package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import com.framework.utils.JsonParse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends BasePage {

    @FindBy(id = "tabButton")
    private BrowserElements tabButton;

    @FindBy(id = "windowButton")
    private BrowserElements windowButton;

    @FindBy(id = "messageWindowButton")
    private BrowserElements messageWindowButton;

    @FindBy(id = "sampleHeading")
    private BrowserElements sampleHeading;

    @FindBy(xpath = "/html/body")
    private BrowserElements pageBody;

    public void openBrowserWindowsPage() {
        WebDriverContext.getDriver().get((JsonParse.getPropertyFromJson("browserWindowsPage")));
    }

    public BrowserWindowsPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    public void clickAndSwitchToTabButton() {
        tabButton.click();
        WebDriverContext.switchToTab(WebDriverContext.getHandle(1));
    }

    public void clickAndSwitchToWindowButton() {
        windowButton.click();
        WebDriverContext.switchToTab(WebDriverContext.getHandle(1));
    }

    public void clickAndSwitchToMessageWindowButton() {
        messageWindowButton.click();
        WebDriverContext.switchToTab(WebDriverContext.getHandle(1));
    }

    public String getTextFromSampleHeading() {
        return sampleHeading.getText();
    }

    public String getTextFromBody() {
        return pageBody.getText();
    }
}
