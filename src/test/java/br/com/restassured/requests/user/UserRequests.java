package br.com.restassured.requests.user;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.data.user.DataUser;
import io.restassured.response.Response;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.*;
import static br.com.restassured.commons.HandleProperties.getValue;
public class UserRequests {

    RequestSpecificationSetup spec = new RequestSpecificationSetup();
    public Response getUsers(){
        return given()
                .spec(spec.setRequestSpecification()).
            when().get("/usuarios").
            then().extract().response();
    }

    public Response createUser(){
        DataUser user = new DataUser();

        return given()
                .spec(spec.setRequestSpecification())
                .body(user.getUserSuccess(user)).
            when().post("/usuarios").
            then().extract().response();
    }

    public Response createDuplicatedUser(){
        DataUser user = new DataUser();
        user.getUserSuccess(user);
        user.setEmail(getValue("USER"));

        return given()
                .spec(spec.setRequestSpecification())
                .body(user).
            when().post("/usuarios").
            then().extract().response();
    }

    public Response editUser(String _id){
        DataUser user = new DataUser();
        return given()
                .spec(spec.setRequestSpecification())
                .body(user.getUserSuccess(user)).
            when().put("/usuarios/"+_id).
            then().extract().response();
    }

    public Response deleteUser(String _id){
        return given()
                .spec(spec.setRequestSpecification()).
            when().delete("/usuarios/"+_id).
            then().extract().response();
    }
}
