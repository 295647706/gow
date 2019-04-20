package com.gow.beau.storage.auto.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Long id;

    private String customerUsername;

    private String mobile;

    private String customerPassword;

    private String customerNickname;

    private String sex;

    private Date birthday;

    private String customerRealname;

    private String address;

    private String loginIp;

    private Date loginTime;

    private String customerImg;

    private String captcha;

    private Date aeadTime;

    private String pwdCaptcha;

    private Date pwdAeadTime;

    private Long loginErrorCount;

    private String userSaltVal;

    private String customerReferee;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername == null ? null : customerUsername.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword == null ? null : customerPassword.trim();
    }

    public String getCustomerNickname() {
        return customerNickname;
    }

    public void setCustomerNickname(String customerNickname) {
        this.customerNickname = customerNickname == null ? null : customerNickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCustomerRealname() {
        return customerRealname;
    }

    public void setCustomerRealname(String customerRealname) {
        this.customerRealname = customerRealname == null ? null : customerRealname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getCustomerImg() {
        return customerImg;
    }

    public void setCustomerImg(String customerImg) {
        this.customerImg = customerImg == null ? null : customerImg.trim();
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public Date getAeadTime() {
        return aeadTime;
    }

    public void setAeadTime(Date aeadTime) {
        this.aeadTime = aeadTime;
    }

    public String getPwdCaptcha() {
        return pwdCaptcha;
    }

    public void setPwdCaptcha(String pwdCaptcha) {
        this.pwdCaptcha = pwdCaptcha == null ? null : pwdCaptcha.trim();
    }

    public Date getPwdAeadTime() {
        return pwdAeadTime;
    }

    public void setPwdAeadTime(Date pwdAeadTime) {
        this.pwdAeadTime = pwdAeadTime;
    }

    public Long getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(Long loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    public String getUserSaltVal() {
        return userSaltVal;
    }

    public void setUserSaltVal(String userSaltVal) {
        this.userSaltVal = userSaltVal == null ? null : userSaltVal.trim();
    }

    public String getCustomerReferee() {
        return customerReferee;
    }

    public void setCustomerReferee(String customerReferee) {
        this.customerReferee = customerReferee == null ? null : customerReferee.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}