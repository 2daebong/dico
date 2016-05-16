package com.helicopter.dico.common.user.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 13..
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private String userId;
    @NotNull
    private String password;
    @NotNull
    private String address;
    @NotNull
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registYmdt;

    private Date updateYmdt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
