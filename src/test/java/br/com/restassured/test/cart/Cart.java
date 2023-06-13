package br.com.restassured.test.cart;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.data.cart.CartProducts;
import br.com.restassured.data.cart.DataCart;
import br.com.restassured.requests.cart.CartRequests;
import br.com.restassured.requests.login.LoginRequests;
import br.com.restassured.requests.products.ProductsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.xml.crypto.Data;

import static org.junit.Assert.assertEquals;

public class Cart {

    private final LoginRequests login = new LoginRequests();
    private final CartRequests request = new CartRequests();
    private static Response response;
    private String token;
    private String _id;

    @Before
    public void setUpProducts(){
        Response loginToken = login.postLoginSuccess();
        token = loginToken.getBody().jsonPath().get("authorization");

        ProductsRequests prod = new ProductsRequests();
        Response response = prod.postProduct(token);
        _id = response.getBody().jsonPath().get("_id");
    }

    @Test
    public void getCarts(){
        response = request.getCarts();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

    @Test
    public void postNewCart(){
      response = request.postCart(token, _id, 2);
        assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        assertEquals(response.getBody().jsonPath().get("message"),"Cadastro realizado com sucesso");
    }
}
