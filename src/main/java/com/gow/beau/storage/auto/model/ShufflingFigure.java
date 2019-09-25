package com.gow.beau.storage.auto.model;

import java.util.Date;

public class ShufflingFigure {
    private Long id;

    private String name;

    private String url;

    private Integer shufflingFigureNumberId;

    private String type;

    private Integer sort;

    private Date createTime;

    private Date modifyTime;

    private String isDelete;

    private Date deleteTime;

    private String isUse;

    private Date validityTime;

    private String isExternalUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getShufflingFigureNumberId() {
        return shufflingFigureNumberId;
    }

    public void setShufflingFigureNumberId(Integer shufflingFigureNumberId) {
        this.shufflingFigureNumberId = shufflingFigureNumberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
    }

    public Date getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    public String getIsExternalUrl() {
        return isExternalUrl;
    }

    public void setIsExternalUrl(String isExternalUrl) {
        this.isExternalUrl = isExternalUrl == null ? null : isExternalUrl.trim();
    }
}