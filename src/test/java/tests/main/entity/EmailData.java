package tests.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailData {

    private static final Logger log = LoggerFactory.getLogger(EmailData.class.getName());

    private String subject;
    private String text;

    public EmailData() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailData that = (EmailData) o;
        return Objects.equals(subject, that.subject) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, text);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        log.info("Get subject value " + subject);
        return subject;
    }

    public String getText() {
        log.info("Get body value " + text);
        return text;
    }
}
