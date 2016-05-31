package com.helicopter.dico.common.order.service;

import com.helicopter.dico.common.cart.model.Cart;
import com.helicopter.dico.common.order.entity.Order;
import com.helicopter.dico.common.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 19..
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(Long orderNo) {
        return orderRepository.findOne(orderNo);
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrderListByUser(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Transactional
    public Order doOrder(Cart cart) {

        Order order = new Order(cart);

        Order result = this.addOrder(order);

        return result;
    }
}
