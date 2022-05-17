package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.enums.DemoQaElements;
import org.openqa.selenium.support.FindBy;

public class BaseToolsPage extends BasePage {

    @FindBy(className = "menu-list")
    private BrowserElements menuBrowserElement;

    public void openElement(DemoQaElements element) {
        menuBrowserElement.foundById(element.getIdItem()).click();
    }

}