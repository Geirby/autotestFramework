package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.main.entity.GameObject;

public class GamePage extends BasePage {

    public GamePage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    @FindBy(id = "appHubAppName")
    private BrowserElements name;

    @FindBy(className = "bundle_base_discount")
    private BrowserElements discount;

    @FindBy(className = "discount_final_price")
    private BrowserElements price;

    public GameObject getGamesParameters() {
        String discountValue = null;
        if(discount != null && !WebDriverContext.getDriver().findElements(By.className("bundle_base_discount")).isEmpty()){
            discountValue = discount.getText();
        }
        return new GameObject(name.getText(),price.getText(),discountValue);
    }


}
