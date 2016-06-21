package com.helicopter.dico.mobileweb.home.web;

import com.helicopter.dico.common.product.entity.Product;
import com.helicopter.dico.common.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 6. 15..
 */
@Controller
public class MobileHomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/mweb/home", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/index");

        List<Product> productList = productService.getProductList();
        mv.addObject("productList", productList);

        return mv;
    }

    @RequestMapping(value = "/mweb/login", method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/login");

        return mv;
    }

}
