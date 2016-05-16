package com.helicopter.dico.api.shop.controller;

import com.helicopter.dico.common.shop.entity.Shop;
import com.helicopter.dico.common.shop.service.ShopService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 19..
 */
@RestController
public class ShopController {

    private static final Log logger = LogFactory.getLog(ShopController.class);

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/shopList", method = RequestMethod.GET)
    public List<Shop> getShopList() {
        return shopService.getShopList();
    }

    @RequestMapping(value = "/shop/{shopNo}", method = RequestMethod.GET)
    public Shop getShop(@PathVariable("shopNo")Long shopNo) {
        return shopService.getShop(shopNo);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public Shop addShop(@RequestBody Shop shop) {

        if(logger.isDebugEnabled()){
            logger.debug("add shop : " + shop.toString());
        }

        return shopService.addShop(shop);
    }
}
