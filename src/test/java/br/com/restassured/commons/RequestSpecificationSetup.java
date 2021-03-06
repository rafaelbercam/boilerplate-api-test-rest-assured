package br.com.restassured.commons;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import static br.com.restassured.commons.HandleProperties.getValue;

public class RequestSpecificationSetup {

    public static RequestSpecification requestSpecification;
    @BeforeClass
    public static void setRequestSpecification(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(getValue("APP_URL"))
                .setContentType(ContentType.JSON)
                .build();
    }
}
