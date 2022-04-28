package tests.main.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.main.pages.SliderPage;

public class SliderTest {

    public static final int VALUE = 99;
    private static final Logger log = LoggerFactory.getLogger(SliderTest.class.getName());

    @Test
    public void sliderTest() {
        log.info("Slider test was start");
        SliderPage sliderPage = new SliderPage();
        sliderPage.openSliderPage();
        sliderPage.moveSliderToValue(100, VALUE);
        Assert.assertEquals(sliderPage.getTextFromSlide(), VALUE, "value is correct");
    }
}
