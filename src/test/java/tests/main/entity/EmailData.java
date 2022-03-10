package tests.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailData {

    private static final Logger log = LoggerFactory.getLogger(EmailData.class.getName());

    private String subject;
    private String body;

    public EmailData() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailData that = (EmailData) o;
        return Objects.equals(subject, that.subject) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, body);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        log.info("Get subject value " + subject);
        return subject;
    }

    public String getBody() {
        log.info("Get body value " + body);
        return body;
    }
}
