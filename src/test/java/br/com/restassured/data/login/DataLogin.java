package br.com.restassured.data.login;

import br.com.restassured.data.user.DataUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static br.com.restassured.commons.HandleProperties.getValue;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataLogin {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;


    public DataLogin getLoginSuccess(DataLogin login){
        login.setEmail(getValue("USER"));
        login.setPassword(getValue("PASSWORD"));
        return login;
    }

    public DataLogin getLoginUser(DataUser user){
        DataLogin login = new DataLogin();
        login.setEmail(user.getEmail());
        login.setPassword(user.getPassword());
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
