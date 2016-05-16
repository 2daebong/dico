package com.helicopter.dico.admin;

import com.helicopter.dico.common.product.enums.ProductCategoryEnum;
import com.helicopter.dico.common.shop.entity.Shop;
import com.helicopter.dico.common.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 27..
 */
@Controller
public class AdminHomeController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminIndex() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        return mv;
    }


    @RequestMapping(value = "admin/product", method = RequestMethod.GET)
    public ModelAndView adminProduct() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product");

        List<Shop> shopList = shopService.getShopList();
        mv.addObject("shopList", shopList);

        List<ProductCategoryEnum> categoryList = new ArrayList<>();
        for(ProductCategoryEnum enums : ProductCategoryEnum.values()){
            categoryList.add(enums);
        }
        mv.addObject("categoryList", categoryList);

        return mv;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public ModelAndView adminUser() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user");

        return mv;
    }
}
