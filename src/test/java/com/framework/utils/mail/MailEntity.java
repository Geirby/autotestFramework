package com.framework.utils.mail;

public class MailEntity {

    private String from;
    private String to;
    private String cc;
    private String text;
    private String subject;
    private String date;
    private String password;

    public MailEntity() {
    }

    public MailEntity(String from, String to, String cc, String text, String subject, String date, String password) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.text = text;
        this.subject = subject;
        this.date = date;
        this.password = password;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getCc() {
        return cc;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }
}

