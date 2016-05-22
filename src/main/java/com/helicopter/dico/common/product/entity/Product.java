package com.helicopter.dico.common.product.entity;

import com.helicopter.dico.common.product.enums.ProductCategoryEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productNo;

    @NotNull @Enumerated(EnumType.STRING)
    private ProductCategoryEnum productCategory;

    @NotNull
    private String productNameKr;

    @NotNull
    private String productName;

    @NotNull
    private int price;

    private Long shopNo;

    private String imageUrl;

    private String descText;

    @NotNull
    private int stock;

    private Date registYmdt;

    private Date updateYmdt;

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public String getProductNameKr() {
        return productNameKr;
    }

    public void setProductNameKr(String productNameKr) {
        this.productNameKr = productNameKr;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getShopNo() {
        return shopNo;
    }

    public void setShopNo(Long shopNo) {
        this.shopNo = shopNo;
    }

    public ProductCategoryEnum getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryEnum productCategory) {
        this.productCategory = productCategory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
    }

    public Date getRegistYmdt() {
        return registYmdt;
    }

    public void setRegistYmdt(Date registYmdt) {
        this.registYmdt = registYmdt;
    }

    public Date getUpdateYmdt() {
        return updateYmdt;
    }

    public void setUpdateYmdt(Date updateYmdt) {
        this.updateYmdt = updateYmdt;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
