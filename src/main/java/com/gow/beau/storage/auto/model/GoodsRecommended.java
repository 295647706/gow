package com.gow.beau.storage.auto.model;

import java.util.Date;

public class GoodsRecommended {
    private Long id;

    private Long goodsId;

    private String title;

    private String titleCaptions;

    private String isDelete;

    private Date createTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleCaptions() {
        return titleCaptions;
    }

    public void setTitleCaptions(String titleCaptions) {
        this.titleCaptions = titleCaptions == null ? null : titleCaptions.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}