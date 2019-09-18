package com.gow.beau.model.rsp.goodsrecommended;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName GoodsRecommendedPageRsp
 * @Author lzn
 * @DATE 2019/9/16 10:24
 */
@Data
public class GoodsRecommendedPageRsp {

    private Long goodsRecommendedId;

    private Long goodsId;

    private String title;

    private String titleCaptions;

    private String goodsName;

    private BigDecimal goodsPrice;

    private String goodsImg;

    private String goodsSpec;

    private int goodsNumber;

    //默认是0：正常，1：已删除，2：已下架，-1：商品信息不存在
    private int isUse = 0;
}
