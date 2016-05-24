package com.helicopter.dico.common.cart.repository;

import com.helicopter.dico.common.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 5. 25..
 */
public interface CartRepository extends JpaRepository<Cart, Long>{
//    List<Integer> getProductNoList(String userId);
}
