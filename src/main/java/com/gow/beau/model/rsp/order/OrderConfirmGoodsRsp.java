package com.gow.beau.model.rsp.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lzn on 2019/3/6.
 */
@Data
public class OrderConfirmGoodsRsp {

    private Long id;

    private Long shoppingCartId;

    private String goodsName;

    private String goodsSpec;

    private String goodsNo;

    private BigDecimal goodsPrice;

    private String goodsDeno;

    private Integer goodsNumber;

    private String goodsDetailImg;

    private String goodsImg;

    private BigDecimal goodsSumPrice;
}
