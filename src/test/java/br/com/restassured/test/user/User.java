package br.com.restassured.test.user;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.requests.user.UserRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import  static org.junit.Assert.*;

public class User extends RequestSpecificationSetup {

    private final UserRequests request = new UserRequests();
    private static Response response;
    private static String _id;

    @Test
    public void getUsersSuccess(){
        response = request.getUsers();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

    @Test
    public void postNewUser(){
        response = request.createUser();
        assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
        _id = response.getBody().jsonPath().get("_id");
    }

    @Test
    public void postDuplicatedUser(){
        response = request.createDuplicatedUser();
        assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
        assertEquals("Este email já está sendo usado", response.getBody().jsonPath().get("message"));
    }

    @Test
    public void editUser(){
        response =request.editUser(_id);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Registro alterado com sucesso", response.getBody().jsonPath().get("message"));
    }

    @Test
    public void deleteUser(){
        response = request.deleteUser(_id);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Registro excluído com sucesso", response.getBody().jsonPath().get("message"));
    }
}
