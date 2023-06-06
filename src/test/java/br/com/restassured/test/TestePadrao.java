package br.com.restassured.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class TestePadrao {

    @Test
    public void postLoginSuccess(){
        String endpoint = "http://localhost:3000/login";
        String requestBody = "{\n" +
                "    \"email\": \"fulano@qa.com\",\n" +
                "    \"password\": \"teste\"\n" +
                "}";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getListUsersSuccess(){
        String endpoint = "http://localhost:3000/usuarios";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .log().all();
    }

}
