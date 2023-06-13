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

    public void removerProduto(CartProducts produto) {
        produtos.remove(produto);
    }

    public ArrayList<CartProducts> getProdutos() {
        return produtos;
    }

}
