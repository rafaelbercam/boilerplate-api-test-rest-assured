package br.com.restassured.requests.cart;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.data.cart.DataCart;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CartRequests extends RequestSpecificationSetup {

    public Response getCarts(){
        return given()
                .spec(requestSpecification).
            when().get("/carrinhos").
            then().extract().response();
    }

    public Response postCart(String token, String _id){
        DataCart cart = new DataCart();
        return given()
                .spec(requestSpecification)
                .header("authorization", token)
                .header()
                .body(cart.createCart(_id)).
            when().post("/carrinhos").
            then().extract().response();
    }
}
