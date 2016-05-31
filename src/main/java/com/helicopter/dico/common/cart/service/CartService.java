package com.helicopter.dico.common.cart.service;

import com.helicopter.dico.common.cart.model.Cart;
import com.helicopter.dico.common.cart.model.CartItem;
import com.helicopter.dico.common.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by LeeDaebeom-Mac on 2016. 5. 25..
 */
@Service
public class CartService {

    @Autowired
    private ProductService productService;

    public Cart putInCart(String userId, Long productNo, int amount) {

        return null;
    }

    public Cart getCart(String userId) {
        return null;
    }

    public Cart putInCart(Cart userCart, CartItem item) {
        Map cartItemMap = userCart.getCartItemMap();
        Long key = item.getProduct().getProductNo();

        CartItem cartItem = (CartItem) cartItemMap.get(key);

        int curAmount = cartItem == null ? 0 : cartItem.getAmount();
        item.setAmount(curAmount + item.getAmount());

        cartItemMap.put(key, item);

        userCart.setCartItemMap(cartItemMap);

        return userCart;
    }
}
