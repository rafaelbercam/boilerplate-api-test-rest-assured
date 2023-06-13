package br.com.restassured.requests.cart;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.data.cart.CartProducts;
import br.com.restassured.data.cart.DataCart;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class CartRequests {

    RequestSpecificationSetup spec = new RequestSpecificationSetup();

    public Response getCarts(){
        return given()
                .spec(spec.setRequestSpecification()).
            when().get("/carrinhos").
            then().extract().response();
    }

    public Response postCart(String token, String _id, Integer qtd){
        CartProducts prod = new CartProducts(_id,qtd);
        DataCart cart = new DataCart();
        cart.adicionarProduto(prod);
        return given()
                .spec(spec.setRequestSpecification())
                .header("authorization", token)
                .body(cart).
            when().post("/carrinhos").
            then().extract().response();
    }

    public Response deleteCartCompletePurchase(String token){
        return given()
                .spec(spec.setRequestSpecification())
                .header("authorization", token).
            when().delete("/carrinhos/concluir-compra").
            then().extract().response();
    }

    public Response deleteCartCancelPurchase(String token){
        return given()
                .spec(spec.setRequestSpecification())
                .header("authorization", token).
                when().delete("/carrinhos/cancelar-compra").
                then().extract().response();
    }
}
