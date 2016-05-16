package com.helicopter.dico.common.shop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@Entity
@Table(name = "tb_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopNo;

    @NotNull
    private String shopName;

    private String address;

    private String phoneNumber;

    private Date registYmdt;

    private String registYmdtStr;

    private Date updateYmdt;

    @NotNull
    private String adminUser;

    public String getRegistYmdtStr() {
        return registYmdtStr;
    }

    public void setRegistYmdtStr(String registYmdtStr) {
        this.registYmdtStr = registYmdtStr;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public Long getShopNo() {
        return shopNo;
    }

    public void setShopNo(Long shopNo) {
        this.shopNo = shopNo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "Shop{" +
                "shopNo=" + shopNo +
                ", shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", registYmdt=" + registYmdt +
                ", updateYmdt=" + updateYmdt +
                ", adminUser='" + adminUser + '\'' +
                '}';
    }
}
