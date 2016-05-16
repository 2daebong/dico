package com.helicopter.dico.common.order.repository;

import com.helicopter.dico.common.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 19..
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
