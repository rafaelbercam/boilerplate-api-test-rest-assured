package br.com.restassured.commons;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import static br.com.restassured.commons.HandleProperties.getValue;

public class RequestSpecificationSetup {

    public static RequestSpecification requestSpecification;
    public static RequestSpecification setRequestSpecification(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(getValue("APP_URL"))
                .setContentType(ContentType.JSON)
                .addFilter( new ResponseLoggingFilter())
                .addFilter( new RequestLoggingFilter())
                .build();

        return requestSpecification;
    }
}
