package com.gow.beau.model.rsp.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class OrderListGoodsRsp {

    private Long goodsId;

    private String goodsName;

    private String goodsSpec;

    private BigDecimal goodsPrice;

    private Integer goodsNumber;

    private String goodsImg;
}
