package br.com.restassured.requests.login;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.data.login.DataLogin;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LoginRequests  {

    RequestSpecificationSetup spec = new RequestSpecificationSetup();
    public Response postLoginSuccess(){
        DataLogin login = new DataLogin();
        return given()
                .spec(spec.setRequestSpecification())
                .body(login.getLoginSuccess(login)).
            when()
                .post("/login").
            then().extract().response();
    }

    public Response postLoginFail(){
        DataLogin login = new DataLogin();
        return given()
                .spec(spec.setRequestSpecification())
                .body(login.getLoginFail(login)).
                        when()
                .post("/login").
                        then().extract().response();
    }

    public Response postLoginEmailRequired(){
        DataLogin login = new DataLogin();
        return given()
                .spec(spec.setRequestSpecification())
                .body(login.getLoginEmailRequired(login)).
                        when()
                .post("/login").
                        then().extract().response();
    }
}
