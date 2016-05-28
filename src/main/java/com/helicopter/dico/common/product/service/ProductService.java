package com.helicopter.dico.common.product.service;

import com.helicopter.dico.common.product.entity.Product;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
public interface ProductService {
    Product getProduct(String productName);

    List<Product> getProductList();

    Product addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
