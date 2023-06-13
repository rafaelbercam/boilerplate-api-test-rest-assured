package br.com.restassured.data.cart;

import java.util.ArrayList;

public class DataCart {

    public ArrayList<CartProducts> produtos;

    public DataCart(){
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(CartProducts produto) {
        produtos.add(produto);
    }

}
