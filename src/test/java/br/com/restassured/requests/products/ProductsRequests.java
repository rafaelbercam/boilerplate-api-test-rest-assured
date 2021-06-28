package br.com.restassured.requests.products;

import br.com.restassured.commons.RequestSpecificationSetup;
import br.com.restassured.data.products.DataProducts;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class ProductsRequests extends RequestSpecificationSetup {

    public Response getProducts(){
        return given()
                .spec(requestSpecification).
            when().get("/produtos").
            then().extract().response();
    }

    public Response getProductById(String _id){
        return given()
                .spec(requestSpecification).
            when().get("/produtos/"+_id).
            then().extract().response();
    }

    public Response postProduct(String token){
        DataProducts product = new DataProducts();

        return given()
                .spec(requestSpecification)
                .header("Authorization", token)
                .body(product.getProduct(product)).
            when().post("/produtos").
            then().extract().response();
    }

    public Response editProduct(String token, String _id){
        DataProducts product = new DataProducts();

        return given()
                .spec(requestSpecification)
                .header("Authorization",token)
                .body(product.getProduct(product)).
            when().put("/produtos/"+_id).
            then().extract().response();
    }

    public Response deleteProduct(String token, String _id){
        return given()
                .spec(requestSpecification)
                .header("Authorization", token).
            when().delete("/produtos/"+_id).
            then().extract().response();
    }

}
