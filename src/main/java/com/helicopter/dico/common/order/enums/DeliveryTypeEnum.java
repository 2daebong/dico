package com.helicopter.dico.common.order.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
public enum DeliveryTypeEnum {
    DELIVERY("배달"),
    PICKUP("방문");

    private String nameKr;

    DeliveryTypeEnum(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
