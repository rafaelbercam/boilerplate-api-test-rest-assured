package br.com.restassured.data.products;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataProducts {

    private String nome;
    private String preco;
    private String descricao;
    private String quantidade;


    public DataProducts getProduct(DataProducts products){
        Faker faker = new Faker(new Locale("pt-BR"));
        Long quantidade = faker.number().randomNumber();
        Integer preco = faker.number().numberBetween(50,500);
        products.setNome(faker.commerce().productName());
        products.setPreco(preco.toString());
        products.setDescricao(faker.commerce().material());
        products.setQuantidade(quantidade.toString());

        return products;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
