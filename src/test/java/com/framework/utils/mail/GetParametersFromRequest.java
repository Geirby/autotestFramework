package com.framework.utils.mail;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class GetParametersFromRequest {

    public static final String GET_REQUEST_FOR_MAILTO = "https://tempmail.plus/api/mails/359050079?email=qa.automation1191@mailto.plus&epin=";

    public static String getReuest () {
        Response response = get(GET_REQUEST_FOR_MAILTO);
        return response.asString();
    }
}
