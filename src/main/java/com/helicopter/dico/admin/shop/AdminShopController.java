package com.helicopter.dico.admin.shop;

import com.helicopter.dico.common.shop.entity.Shop;
import com.helicopter.dico.common.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 27..
 */
@Controller
public class AdminShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "admin/shop", method = RequestMethod.GET)
    public ModelAndView adminShop() {

        List<Shop> shopList = shopService.getShopList();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("shop");
        mv.addObject("shopList", shopList);

        return mv;
    }

}
