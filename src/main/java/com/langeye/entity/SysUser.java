package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Fish on 2015/11/6.
 */
@Entity
@Table(name = "UC_SysUser")
public class SysUser extends GeneralEntity {

    private String name;
    private String account;
    private String password;
    private String authCode;
    private String salt;
    private int sex;
    private int state;

    private String sign;
    private String avotor;

    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvotor() {
        return avotor;
    }

    public void setAvotor(String avotor) {
        this.avotor = avotor;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
