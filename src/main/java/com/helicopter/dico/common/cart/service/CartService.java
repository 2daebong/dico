package com.helicopter.dico.common.cart.service;

import com.helicopter.dico.common.cart.entity.Cart;
import com.helicopter.dico.common.cart.repository.CartRepository;
import com.helicopter.dico.common.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 5. 25..
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getOrderList() {
        return cartRepository.findAll();
    }

    public Cart addOrder(Cart order) {
        return cartRepository.save(order);
    }

    public List<Product> getUserCart(String userId) {
//        cartRepository.getProductNoList(userId);
        //TODO : 작업중
        return null;
    }
}
