package com.helicopter.dico.common.product.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
public enum ProductCategoryEnum {
    VEGETABLE("야채"),
    FRUIT("과일"),
    ANIMAL("축산/계란"),
    SSAL("쌀/잡곡/견과"),
    DRIED_FISH("건어물"),
    ETC("기타");

    private String nameKr;

    ProductCategoryEnum(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
