package com.helicopter.dico.api.cart.controller;

import com.helicopter.dico.common.cart.model.Cart;
import com.helicopter.dico.common.cart.model.CartItem;
import com.helicopter.dico.common.cart.service.CartService;
import com.helicopter.dico.common.order.entity.Order;
import com.helicopter.dico.common.order.service.OrderService;
import com.helicopter.dico.common.product.entity.Product;
import com.helicopter.dico.common.product.service.ProductService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by LeeDaebeom-Mac on 2016. 5. 25..
 */
@RestController
@Scope("session")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/api/cart", method = RequestMethod.POST)
    public Cart addItemInCart(@RequestBody Map<String, Object> body,
                              HttpServletRequest request) {

        String userId = MapUtils.getString(body, "userId");
        Long productNo = MapUtils.getLong(body, "productNo");
        int amount = MapUtils.getInteger(body, "amount");

        CartItem item = new CartItem();
        item.setProduct(productService.getProduct(productNo));
        item.setAmount(amount);

        Cart userCart = (Cart) request.getSession().getAttribute("cart");

        if( userCart == null
            || !StringUtils.equals(userCart.getUserId(), userId)) {
            userCart = new Cart(userId, item); // 신규 카트 생성
        } else {
            userCart = cartService.putInCart(userCart, item);
        }

        List<CartItem> cartItemList = new ArrayList<>(userCart.getCartItemMap().values());

        request.getSession().setAttribute("cart", userCart);
        request.getSession().setAttribute("cartItemList", cartItemList);

        return userCart;
    }

//    @RequestMapping(value = "/api/cart/{userId}", method = RequestMethod.GET)
//    public Cart getUserCart(@PathVariable String userId) {
//        return cartService.getMergedCartByUser(userId);
//    }


    // cart를 통한 주문
    @RequestMapping(value = "/api/cart/order/{userId}", method = RequestMethod.POST)
    public Order doOrder(@PathVariable String userId) {
        // TODO : 트랜잭션 처리

//        UserCart userCart = cartService.getMergedCartByUser(userId);
//
//        Order order = new Order(userCart);
//        orderService.addOrder(order);
//
//        cartService.delete(userId); // 저장되어 있던 카트 제거
//        return order;
        return null;
    }
}
