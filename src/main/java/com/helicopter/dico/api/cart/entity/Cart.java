package com.helicopter.dico.api.cart.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@Entity
@Table(name = "tb_cart")
@Deprecated
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartNo;

    @NotNull
    private String userId;

    @NotNull
    private String productNo;

    @NotNull
    private int amount;

    private String registYmdt;

    private String updateYmdt;

    public Long getCartNo() {
        return cartNo;
    }

    public void setCartNo(Long cartNo) {
        this.cartNo = cartNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getRegistYmdt() {
        return registYmdt;
    }

    public void setRegistYmdt(String registYmdt) {
        this.registYmdt = registYmdt;
    }

    public String getUpdateYmdt() {
        return updateYmdt;
    }

    public void setUpdateYmdt(String updateYmdt) {
        this.updateYmdt = updateYmdt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
