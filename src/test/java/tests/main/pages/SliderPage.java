package tests.main.pages;

import com.framework.base.BasePage;
import com.framework.base.BrowserElements;
import com.framework.context.WebDriverContext;
import com.framework.decorator.CustomFieldDecorator;
import com.framework.utils.JsonParse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sliderContainer\"]/div[1]/span/input")
    private BrowserElements sliderElement;

    @FindBy(id = "sliderValue")
    private BrowserElements sliderValue;

    public SliderPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverContext.getDriver()), this);
    }

    public void openSliderPage() {
        WebDriverContext.getDriver().get((JsonParse.getPropertyFromJson("sliderPage")));
    }

    public void moveSliderToValue(Integer maxValue, Integer value) {
        sliderElement.moveSliderToValue(maxValue, value);
    }

    public int getTextFromSlide() {
        return Integer.parseInt(sliderValue.getAttribute("value"));
    }

}
