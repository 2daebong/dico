package com.helicopter.dico.common.product.repository;

import com.helicopter.dico.common.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByProductName(String productName);
}
