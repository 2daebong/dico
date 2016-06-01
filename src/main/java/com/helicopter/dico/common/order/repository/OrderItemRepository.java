package com.helicopter.dico.common.order.repository;

import com.helicopter.dico.common.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 6. 2..
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
