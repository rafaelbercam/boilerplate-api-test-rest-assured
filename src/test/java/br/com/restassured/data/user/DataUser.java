package br.com.restassured.data.user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataUser {


    private String nome;
    private String email;
    private String password;
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


    public String getNome() {
        return nome;
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

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
}
