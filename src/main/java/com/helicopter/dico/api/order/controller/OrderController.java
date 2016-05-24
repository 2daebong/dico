package com.helicopter.dico.api.order.controller;

import com.helicopter.dico.common.order.entity.Order;
import com.helicopter.dico.common.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 19..
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public Order getOrder(@RequestParam Long orderNo){
        return orderService.getOrder(orderNo);
    }

    @RequestMapping(value = "/api/orderList", method = RequestMethod.GET)
    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }

    @RequestMapping(value = "/api/order/addOrder", method = RequestMethod.POST)
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
}
