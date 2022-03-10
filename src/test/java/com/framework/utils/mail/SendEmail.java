package com.framework.utils.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmail {

    private static final Logger log = LoggerFactory.getLogger(SendEmail.class);
    public static final String SMTP_MAIL_RU = "smtp.mail.ru";
    public static final String SMTP_MAIL_RU_PORT = "465";

    private Message message;



    public SendEmail(final MailConfig config) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_MAIL_RU);
        properties.put("mail.smtp.port", SMTP_MAIL_RU_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        try {
            Authenticator auth = new EmailAuthenticator(config.getFrom(),
                    config.getPassword());
            Session session = Session.getDefaultInstance(properties, auth);
            session.setDebug(false);

            InternetAddress emailFrom = new InternetAddress(config.getFrom());
            InternetAddress emailTo = new InternetAddress(config.getTo());
            InternetAddress[] cc = InternetAddress.parse(config.getCc());
            message = new MimeMessage(session);
            message.setFrom(emailFrom);
            message.setRecipients(Message.RecipientType.CC, cc);
            message.setRecipient(Message.RecipientType.TO, emailTo);
            message.setSubject(config.getSubject());
        } catch (MessagingException e) {
            log.error(e.getMessage());
        }
    }

    public boolean sendMessage(final String text) {
        boolean result = false;
        try {
            Multipart mmp = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(text, "text/plain; charset=utf-8");
            mmp.addBodyPart(bodyPart);
            message.setContent(mmp);
            Transport.send(message);
            result = true;
        } catch (MessagingException e) {
            log.error(e.getMessage());
        }
        return result;
    }
}
