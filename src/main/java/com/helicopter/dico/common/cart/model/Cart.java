package com.helicopter.dico.common.cart.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
public class Cart {

    private String userId;

    Map<Long, CartItem> cartItemMap;

    public Cart(String userId, CartItem item) {
        this.userId = userId;
        cartItemMap = new HashMap<>();
        cartItemMap.put(item.getProduct().getProductNo(), item);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<Long, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Long, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }
}
