package br.com.restassured.data.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartProducts {
    @JsonProperty("idProduto")
    private String idProduto;
    @JsonProperty("quantidade")
    private Integer quantidade;

    public CartProducts(String idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

}
