package com.framework.utils.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailHelper {

    private static final Logger log = LoggerFactory.getLogger(MailHelper.class);
    public static final String SMTP_MAIL_RU = "smtp.mail.ru";
    public static final String SMTP_MAIL_RU_PORT = "465";
    public static final String MAIL_CONTENT_TYPE = "text/plain; charset=utf-8";

    private static final Properties properties = initProperties();

    private static Properties initProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_MAIL_RU);
        properties.put("mail.smtp.port", SMTP_MAIL_RU_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        return properties;
    }

    private static MimeMessage createMimeMessage(MailEntity config) {
       MimeMessage mimeMessage = null;
        try {
            Authenticator auth = new EmailAuthenticator(config.getFrom(),
                    config.getPassword());
            Session session = Session.getDefaultInstance(properties, auth);
            session.setDebug(false);

            InternetAddress emailFrom = new InternetAddress(config.getFrom());
            InternetAddress emailTo = new InternetAddress(config.getTo());
            InternetAddress[] cc = InternetAddress.parse(config.getCc());
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(emailFrom);
            mimeMessage.setRecipients(Message.RecipientType.CC, cc);
            mimeMessage.setRecipient(Message.RecipientType.TO, emailTo);
            mimeMessage.setSubject(config.getSubject());
        } catch (MessagingException e) {
            log.error("Can not create mime message", e);
        }
        return mimeMessage;
    }

    public static boolean sendMessage(final MailEntity mailEntity) {
        boolean result = false;
        try {
            MimeMessage message = createMimeMessage(mailEntity);
            Multipart mmp = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(mailEntity.getText(), MAIL_CONTENT_TYPE);
            mmp.addBodyPart(bodyPart);
            message.setContent(mmp);
            Transport.send(message);
            result = true;
        } catch (MessagingException e) {
            log.error("Mail can not be sent", e);
        }
        return result;
    }
}
