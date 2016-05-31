package com.helicopter.dico.common.order.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
public enum OrderStatusEnum {
    COMPLETE("배달 완료"),
    CANCEL("취소"),
    DELIVERING("배달 중"),
    WAIT("준비 중");

    private String nameKr;


    OrderStatusEnum(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
