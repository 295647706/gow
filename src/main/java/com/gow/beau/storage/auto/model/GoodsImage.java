package com.gow.beau.storage.auto.model;

public class GoodsImage {
    private Long id;

    private Long goodsId;

    private String imageUrl;

    private String isOtherImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getIsOtherImg() {
        return isOtherImg;
    }

    public void setIsOtherImg(String isOtherImg) {
        this.isOtherImg = isOtherImg == null ? null : isOtherImg.trim();
    }
}