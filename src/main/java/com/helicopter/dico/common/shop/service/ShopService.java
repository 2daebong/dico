package com.helicopter.dico.common.shop.service;

import com.helicopter.dico.common.shop.entity.Shop;
import com.helicopter.dico.common.shop.repository.ShopRepository;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 19..
 */
@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getShopList(){
        return shopRepository.findAll();
    }

    public Shop getShop(Long shopNo) {
        Shop shop = shopRepository.findOne(shopNo);

        String presentedDate = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss").format(shop.getRegistYmdt());
        shop.setRegistYmdtStr(presentedDate);

        return shop;
    }
    
    public Shop addShop(Shop shop) {
        shop.setRegistYmdt(new Date());
        return shopRepository.save(shop);
    }
}
