package br.com.restassured.test.login;

import br.com.restassured.requests.login.LoginRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class Login {

    private final LoginRequests request = new LoginRequests();
    public static String token;
    private static Response response;

    @Test
    public void postLoginSuccess(){
        response = request.postLoginSuccess();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Login realizado com sucesso", response.getBody().jsonPath().get("message"));
    }

    @Test
    public void postLoginFail(){
        response = request.postLoginFail();
        assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
        assertEquals("Email e/ou senha inválidos", response.getBody().jsonPath().get("message"));
    }

    @Test
    public void postLoginEmailRequired(){
        response = request.postLoginEmailRequired();
        assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
        assertEquals("email não pode ficar em branco", response.getBody().jsonPath().get("email"));
    }

}
