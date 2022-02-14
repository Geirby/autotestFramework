package com.framework.base;


import com.framework.context.WebDriverContext;
import com.framework.utils.JsonParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class.getName());

    @BeforeClass
    protected void setupDriver() {
        WebDriverContext.setDriver();
        WebDriverContext.getDriver().manage().window().maximize();
        WebDriverContext.getDriver().get(JsonParse.getPropertyFromJson("mainPage"));
        log.info("Web driver was setup");
    }

    @AfterClass
    protected void tearDown() {
        WebDriverContext.quiteDriver();
        WebDriverContext.removeDriver();
        log.info("Web driver removed");
    }
}


