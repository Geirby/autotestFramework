package com.framework.utils.mail;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;

public class TestEmail {

    private static final Logger log = LoggerFactory.getLogger(TestEmail.class.getName());

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            MailConfig mailConfig = mapper.readValue(Paths.get("src/test/resources/email.properties.json").toFile(), MailConfig.class);

            if (mailConfig != null) {

                SendEmail se = new SendEmail(mailConfig);
                se.sendMessage(mailConfig.getText());
                log.info("Message was sent");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

