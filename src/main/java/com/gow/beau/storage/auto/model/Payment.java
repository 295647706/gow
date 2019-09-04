package com.gow.beau.storage.auto.model;

import java.math.BigDecimal;

public class Payment {
    private Long id;

    private String path;

    private String notifyUrl;

    private String returnUrl;

    private String apiUrl;

    private String appEcret;

    private Integer expire;

    private BigDecimal defaultPrice;

    private String isDefaultPrice;

    private String uid;

    private String useType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    public String getAppEcret() {
        return appEcret;
    }

    public void setAppEcret(String appEcret) {
        this.appEcret = appEcret == null ? null : appEcret.trim();
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getIsDefaultPrice() {
        return isDefaultPrice;
    }

    public void setIsDefaultPrice(String isDefaultPrice) {
        this.isDefaultPrice = isDefaultPrice == null ? null : isDefaultPrice.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }
}