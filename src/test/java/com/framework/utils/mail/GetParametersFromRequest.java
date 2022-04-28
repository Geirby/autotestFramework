package com.framework.utils.mail;

import static io.restassured.RestAssured.get;

public class GetParametersFromRequest {

    public static String GetParametersFromRequest(String mailAddress) {


        String mailUrl = get("https://tempmail.plus/api/mails?email="+mailAddress+"&limit=20&epin=").getBody().asString();
        String mailData = null;

        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            org.json.simple.JSONObject getMailId = (org.json.simple.JSONObject) parser.parse(mailUrl);
            Long mailId = (Long) getMailId.get("first_id");
            mailData = get("https://tempmail.plus/api/mails/"+mailId+"?email="+mailAddress+"&epin=").getBody().asString();
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error: " + e);
        }
        return mailData;
    }
}
//https://tempmail.plus/api/mails/432093022?email=qa.automation1191@mailto.plus&epin=