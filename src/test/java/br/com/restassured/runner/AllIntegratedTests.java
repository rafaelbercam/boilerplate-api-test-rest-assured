package br.com.restassured.runner;

import br.com.restassured.test.cart.Cart;
import br.com.restassured.test.login.Login;
import br.com.restassured.test.products.Products;
import br.com.restassured.test.user.User;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Login.class,
        User.class,
        Products.class,
        Cart.class
})
public class AllIntegratedTests {}
