package com.gow.beau.storage.auto.model;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Long id;

    private Long categoryId;

    private String goodsName;

    private String goodsSpec;

    private String goodsSubtitle;

    private String goodsNo;

    private String goodsKeywords;

    private String goodsBrief;

    private BigDecimal goodsPrice;

    private BigDecimal goodsOldPrice;

    private String goodsImg;

    private BigDecimal goodsScore;

    private String goodsDeno;

    private String goodsDetailImg;

    private Integer goodsNumber;

    private String isDelete;

    private String isUpperLowerRacks;

    private String isRecommend;

    private Date createTime;

    private String goodsDetailDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }

    public String getGoodsSubtitle() {
        return goodsSubtitle;
    }

    public void setGoodsSubtitle(String goodsSubtitle) {
        this.goodsSubtitle = goodsSubtitle == null ? null : goodsSubtitle.trim();
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public String getGoodsKeywords() {
        return goodsKeywords;
    }

    public void setGoodsKeywords(String goodsKeywords) {
        this.goodsKeywords = goodsKeywords == null ? null : goodsKeywords.trim();
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief == null ? null : goodsBrief.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsOldPrice() {
        return goodsOldPrice;
    }

    public void setGoodsOldPrice(BigDecimal goodsOldPrice) {
        this.goodsOldPrice = goodsOldPrice;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public BigDecimal getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(BigDecimal goodsScore) {
        this.goodsScore = goodsScore;
    }

    public String getGoodsDeno() {
        return goodsDeno;
    }

    public void setGoodsDeno(String goodsDeno) {
        this.goodsDeno = goodsDeno == null ? null : goodsDeno.trim();
    }

    public String getGoodsDetailImg() {
        return goodsDetailImg;
    }

    public void setGoodsDetailImg(String goodsDetailImg) {
        this.goodsDetailImg = goodsDetailImg == null ? null : goodsDetailImg.trim();
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getIsUpperLowerRacks() {
        return isUpperLowerRacks;
    }

    public void setIsUpperLowerRacks(String isUpperLowerRacks) {
        this.isUpperLowerRacks = isUpperLowerRacks == null ? null : isUpperLowerRacks.trim();
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend == null ? null : isRecommend.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGoodsDetailDesc() {
        return goodsDetailDesc;
    }

    public void setGoodsDetailDesc(String goodsDetailDesc) {
        this.goodsDetailDesc = goodsDetailDesc == null ? null : goodsDetailDesc.trim();
    }
}