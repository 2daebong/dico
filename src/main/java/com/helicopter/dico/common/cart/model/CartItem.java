package com.helicopter.dico.common.cart.model;

import com.helicopter.dico.common.product.entity.Product;

/**
 * Created by LeeDaebeom-Mac on 2016. 5. 31..
 */
public class CartItem {

    private Product product;

    private int amount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
