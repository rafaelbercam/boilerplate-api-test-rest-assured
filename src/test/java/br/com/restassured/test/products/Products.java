package br.com.restassured.test.products;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.requests.login.LoginRequests;
import br.com.restassured.requests.products.ProductsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class Products {
    private final ProductsRequests request = new ProductsRequests();
    private final LoginRequests login = new LoginRequests();
    private static Response response;
    private static String token;
    private static String _id;


    @Before
    public void ScenarioSetup(){
        Response loginToken = login.postLoginSuccess();
        token = loginToken.getBody().jsonPath().get("authorization");

        Response idProduct = request.postProduct(token);
        _id = idProduct.getBody().jsonPath().get("_id");
    }

    @Test
    public void getProducts(){
        response = request.getProducts();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

    @Test
    public void postNewProduct(){
        response = request.postProduct(token);
        assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
    }

    @Test
    public void getProductById(){
        response = request.getProductById(_id);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

    @Test
    public void editProduct(){
        response = request.editProduct(token, _id);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Registro alterado com sucesso", response.getBody().jsonPath().get("message"));
    }

    @Test
    public void deleteProduct(){
        Response deleteProduct = request.postProduct(token);
        String _id = deleteProduct.getBody().jsonPath().get("_id");
        response = request.deleteProduct(token, _id);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Registro excluído com sucesso", response.getBody().jsonPath().get("message"));
    }
}
