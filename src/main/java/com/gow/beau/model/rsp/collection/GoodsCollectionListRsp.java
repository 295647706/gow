package com.gow.beau.model.rsp.collection;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lzn on 2019/3/13.
 */
@Data
public class GoodsCollectionListRsp {

    private long collectionId;

    private Long goodsId;

    private String goodsName;

    private String goodsSpec;

    private BigDecimal goodsPrice;

    private String goodsImg;
}
