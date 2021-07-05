package br.com.restassured.data.cart;

import org.json.JSONObject;

public class DataCart {

    private String cart;

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public JSONObject createCart(String _id){
        setCart("{\"produtos\":[{\"idProduto\":"+_id+",\"quantidade\":4}]}");
        JSONObject jsonObj = new JSONObject(cart);
        return jsonObj;
    }
}
