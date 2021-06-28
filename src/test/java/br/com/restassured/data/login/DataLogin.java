package br.com.restassured.data.login;

import static br.com.restassured.commons.HandleProperties.getValue;
public class DataLogin {

    private String email;
    private String password;


    public DataLogin getLoginSuccess(DataLogin login){
        login.setEmail(getValue("USER"));
        login.setPassword(getValue("PASSWORD"));
        return login;
    }

    public DataLogin getLoginFail(DataLogin login){
        login.setEmail(getValue("USER"));
        login.setPassword("tes");
        return login;
    }

    public DataLogin getLoginEmailRequired(DataLogin login){
        login.setEmail("");
        login.setPassword(getValue("PASSWORD"));
        return login;
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
}
