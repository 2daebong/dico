package com.helicopter.dico.common.order.entity;

import com.helicopter.dico.common.product.entity.Product;

import javax.persistence.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 6. 2..
 */
@Entity
@Table(name = "tb_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_seq")
    private Long seq;

    private Long orderNo;

    @ManyToOne
    @JoinColumn(name = "product_no")
    private Product product;

    private int count;

    public OrderItem() {

    }

    public OrderItem(Order order, Product product, int amount) {
        this.product = product;
        this.count = amount;
        this.orderNo = order.getOrderNo();
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
