package com.helicopter.dico.common.cart.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@Entity
@Table(name = "tb_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartSeq;

    @NotNull
    private String userId;

    @NotNull
    private String productNo;

    @NotNull
    private int amount;

    private String registYmdt;

    private String updateYmdt;

    public Long getCartSeq() {
        return cartSeq;
    }

    public void setCartSeq(Long cartSeq) {
        this.cartSeq = cartSeq;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
}
