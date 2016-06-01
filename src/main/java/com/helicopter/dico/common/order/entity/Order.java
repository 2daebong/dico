package com.helicopter.dico.common.order.entity;

import com.helicopter.dico.common.cart.model.Cart;
import com.helicopter.dico.common.cart.model.CartItem;
import com.helicopter.dico.common.order.enums.DeliveryTypeEnum;
import com.helicopter.dico.common.order.enums.OrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private String address;

    private String phone;

    @OneToMany
    @JoinColumn(name = "orderNo")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @NotNull
    private int totalPrice;

    @NotNull @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @NotNull @Enumerated(EnumType.STRING)
    private DeliveryTypeEnum deliveryType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registYmdt;

    private Date updateYmdt;

    public Order() {

    }

    public Order(Cart userCart) {
        this.userId = userCart.getUserId();
        //TODO : 추가해야 할 사항
//        this.address = userService.getUserAddress(userCart.getUserId());
//        this.phone = userService.getUserPhone(userCart.getUserId());

        for(CartItem cartItem : userCart.getCartItemMap().values()) {
            this.totalPrice += cartItem.getProduct().getPrice() * cartItem.getAmount();
        }

        this.status = OrderStatusEnum.WAIT;
        this.deliveryType = DeliveryTypeEnum.DELIVERY;
        this.registYmdt = new Date();
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
}
