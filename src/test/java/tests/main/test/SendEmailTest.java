package tests.main.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseTest;
import com.framework.utils.mail.GetParametersFromRequest;
import com.framework.utils.mail.MailConfig;
import com.framework.utils.mail.SendEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.main.entity.EmailData;
import tests.main.pages.YopMailPage;

import java.io.IOException;
import java.nio.file.Paths;

public class SendEmailTest extends BaseTest {

    public static final String SRC_TEST_RESOURCES_EMAIL_PROPERTIES_JSON = "src/test/resources/email.properties.json";
    private static final Logger log = LoggerFactory.getLogger(SendEmailTest.class.getName());

    @BeforeTest
    public void preCondition() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            MailConfig mailConfig = mapper.readValue(Paths.get(SRC_TEST_RESOURCES_EMAIL_PROPERTIES_JSON).toFile(), MailConfig.class);

            if (mailConfig != null) {

                SendEmail se = new SendEmail(mailConfig);
                se.sendMessage(mailConfig.getText());
                log.info("Message was sent");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendEmailTest() throws JsonProcessingException {
        log.info("Get mail parameters from yopmail");
        YopMailPage yopMailPage = new YopMailPage();
        ObjectMapper objectMapper = new ObjectMapper();
        yopMailPage.enterEmailInField();
        yopMailPage.switchToIframe();
        EmailData emailFromYopMail = yopMailPage.getEmailParameters();
        EmailData emailFromMailTo = objectMapper.readValue(GetParametersFromRequest.getReuest(), EmailData.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(emailFromMailTo.getSubject(), emailFromYopMail.getSubject(), "Subject verification");
        softAssert.assertEquals(emailFromMailTo.getBody(), emailFromYopMail.getBody(), "text email verification");
    }
}
