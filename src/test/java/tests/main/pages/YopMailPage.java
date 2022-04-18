package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.main.entity.EmailData;

public class YopMailPage extends BasePage {

    @FindBy(xpath = "//*[@class='ycptinput']")
    private BrowserElements mailInputField;

    @FindBy(xpath = "//*[@class='fl']/div[1]")
    private BrowserElements emailSubject;

    @FindBy(xpath = "//*[@id=\"mail\"]/pre")
    private BrowserElements emailBody;

    @FindBy(id = "ifmail")
    private BrowserElements iframe;

    public YopMailPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    public void enterEmailInField(String mail) {
        mailInputField.enterText(mail);
        mailInputField.pressEnter();
    }

    public void switchToIframe() {
        WebDriverContext.switchToIframe(iframe.getWebElement());
    }

    public EmailData getEmailParameters() {
        EmailData emailData = new EmailData();
        emailData.setSubject(emailSubject.getText());
        emailData.setText(emailBody.getText());
        return emailData;
    }
}

