package com.gow.beau.model.rsp.category;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Date: 2019/2/15 15:48<br/>
 *
 * @author lzn
 */
@Data
public class CategoryGoodsListRsp {

    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String goodsSpec;

    private BigDecimal goodsPrice;

    private String goodsDeno;

    private String goodsNo;
}
