package com.helicopter.dico.api.order.controller;

import com.helicopter.dico.common.cart.model.Cart;
import com.helicopter.dico.common.order.entity.Order;
import com.helicopter.dico.common.order.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/api/order/", method = RequestMethod.POST)
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @RequestMapping(value = "/api/order/cart", method = RequestMethod.POST)
    public Order addOrderByCart(@RequestBody String userId,
                                HttpServletRequest request) {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Order order = null;
        if(StringUtils.equals(cart.getUserId(), userId)) {
            order = orderService.doOrder(cart);
            if(order != null) {
                request.getSession().removeAttribute("cart");
                request.getSession().removeAttribute("cartItemList");
            }
        }

        return order;
    }

}
