package br.com.restassured.runner;

import br.com.restassured.test.login.Login;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Login.class
})
public class AllIntegratedTests {}
