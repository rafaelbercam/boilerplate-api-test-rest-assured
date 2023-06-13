package br.com.restassured.data.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.util.Locale;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataUser {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("administrador")
    private String administrador;

    public DataUser getUserSuccess(DataUser user){
        Faker faker = new Faker(new Locale("pt-BR"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName+lastName;
        String email = fullName.toLowerCase().replaceAll(" ","")+"@email.com";

        user.setNome(firstName+" "+lastName);
        user.setEmail(email);
        user.setPassword(faker.crypto().md5());
        user.setAdministrador("true");

        return user;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
}
