package com.framework.base;

import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }
}
