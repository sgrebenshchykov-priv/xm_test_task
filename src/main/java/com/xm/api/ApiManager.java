package com.xm.api;

import com.xm.core.properties.PropertyController;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiManager {
    private static String baseUrl = PropertyController.commonConfig().wsHost();

    public static Response get(String url) {
        return given()
                .spec(getSpecification())
                .get(url);
    }
    private static RequestSpecification getSpecification() {
        return new RequestSpecBuilder()
                .setUrlEncodingEnabled(false)
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
