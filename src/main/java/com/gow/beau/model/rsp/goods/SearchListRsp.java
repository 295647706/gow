package com.gow.beau.model.rsp.goods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lzn on 2019/3/11.
 */
@Data
public class SearchListRsp {

    private Long id;

    private String goodsName;

    private String goodsSpec;

    private BigDecimal goodsPrice;

    private String goodsImg;
}
