package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.main.entity.EmailData;

public class YopMailPage extends BasePage {

    public YopMailPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    @FindBy(xpath = "//*[@class = 'ycptinput']")
    private BrowserElements mailInputField;

    @FindBy(xpath = "/html/body/header/div[3]/div[1]")
    private BrowserElements emailSubject;

    @FindBy(id = "mail")
    private BrowserElements emailBody;

    @FindBy(id = "ifmail")
    private BrowserElements iframe;

    public void enterEmailInField() {
        String partOfEmail = "qa.automation1190";
        mailInputField.enterText(partOfEmail);
        mailInputField.pressEnter();
    }

    public void switchToIframe() {
        iframe.switchToIframe();
    }

    public EmailData getEmailParameters() {
        //return new EmailData(emailSubject.getText(), emailBody.getText());
        EmailData emailData = new EmailData();
        emailData.setSubject(emailSubject.getText());
        emailData.setBody(emailBody.getText());
        return emailData;
    }
}

