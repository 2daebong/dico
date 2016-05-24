package com.helicopter.dico.api.cart.controller;

import com.helicopter.dico.common.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LeeDaebeom-Mac on 2016. 5. 25..
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;


}
