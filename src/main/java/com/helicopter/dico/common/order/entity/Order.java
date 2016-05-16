package com.helicopter.dico.common.order.entity;

import com.helicopter.dico.common.order.enums.DeliveryTypeEnum;
import com.helicopter.dico.common.order.enums.OrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNo;

    @NotNull
    private String userId;

    private Long shopNo;

    @NotNull
    private String productList;

    @NotNull
    private int totalPrice;

    @NotNull @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @NotNull @Enumerated(EnumType.STRING)
    private DeliveryTypeEnum deliveryType;

    private Date ResitYmdt;

    private Date updateYmdt;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getResitYmdt() {
        return ResitYmdt;
    }

    public void setResitYmdt(Date resitYmdt) {
        ResitYmdt = resitYmdt;
    }

    public Date getUpdateYmdt() {
        return updateYmdt;
    }

    public void setUpdateYmdt(Date updateYmdt) {
        this.updateYmdt = updateYmdt;
    }

    public Long getShopNo() {
        return shopNo;
    }

    public void setShopNo(Long shopNo) {
        this.shopNo = shopNo;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public DeliveryTypeEnum getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryTypeEnum deliveryType) {
        this.deliveryType = deliveryType;
    }
}
