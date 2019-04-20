package com.gow.beau.storage.auto.model;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCart {
    private Long id;

    private Long customerId;

    private Long goodsId;

    private BigDecimal goodsPrice;

    private Long goodsPrePrice;

    private Integer goodsNumber;

    private String delFlag;

    private Date shoppingCartTime;

    private String isShop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsPrePrice() {
        return goodsPrePrice;
    }

    public void setGoodsPrePrice(Long goodsPrePrice) {
        this.goodsPrePrice = goodsPrePrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Date getShoppingCartTime() {
        return shoppingCartTime;
    }

    public void setShoppingCartTime(Date shoppingCartTime) {
        this.shoppingCartTime = shoppingCartTime;
    }

    public String getIsShop() {
        return isShop;
    }

    public void setIsShop(String isShop) {
        this.isShop = isShop == null ? null : isShop.trim();
    }
}