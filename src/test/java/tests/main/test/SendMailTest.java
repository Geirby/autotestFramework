package tests.main.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseTest;
import com.framework.utils.JsonParse;
import com.framework.utils.mail.GetParametersFromRequest;
import com.framework.utils.mail.MailEntity;
import com.framework.utils.mail.MailHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.main.entity.EmailData;
import tests.main.pages.YopMailPage;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.AssertJUnit.assertEquals;

public class SendMailTest extends BaseTest {

    public static final String SRC_TEST_RESOURCES_EMAIL_PROPERTIES_JSON = "src/test/resources/email.properties.json";
    private static final Logger log = LoggerFactory.getLogger(SendMailTest.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @BeforeTest
    public void preCondition() {
        try {
            MailEntity mailEntity = mapper.readValue(Paths.get(SRC_TEST_RESOURCES_EMAIL_PROPERTIES_JSON).toFile(), MailEntity.class);

            if (mailEntity != null) {

                MailHelper.sendMessage(mailEntity);
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
        yopMailPage.enterEmailInField(JsonParse.getPropertyFromJson("to"));
        yopMailPage.switchToIframe();
        EmailData emailFromYopMail = yopMailPage.getEmailParameters();
        EmailData emailFromMailTo = mapper.readValue(GetParametersFromRequest.GetParametersFromRequest(JsonParse.getPropertyFromJson("cc")), EmailData.class);
        assertAll(
                () -> assertEquals("Subject verification",emailFromMailTo.getSubject(), emailFromYopMail.getSubject()),
                () -> assertEquals("text email verification", emailFromMailTo.getText(), emailFromYopMail.getText())
        );
    }
}
