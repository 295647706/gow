package com.gow.beau.model.rsp.goods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Date: 2019/2/15 14:40<br/>
 *
 * @author lzn
 */
@Data
public class GoodsDetailRsp {

    private Long id;

    private String goodsName;

    private String goodsSpec;

    private String goodsNo;

    private BigDecimal goodsPrice;

    private BigDecimal goodsOldPrice;

    private String goodsDeno;

    private Integer goodsNumber;

    private String goodsDetailDesc;

    private String goodsDetailImg;

    //是否已收藏（false:没有收藏，true:已收藏）
    private Boolean isGoodsCollection = false;

    //轮播图
    private List<GoodsImageRsp> goodsImageList;

    private List<String> goodsDetailImgs;
}
