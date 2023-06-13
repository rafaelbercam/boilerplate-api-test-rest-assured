package br.com.restassured.data.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataProducts {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("preco")
    private String preco;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("quantidade")
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


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
