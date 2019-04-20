package com.gow.beau.model.rsp.goodsrecommended;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lzn on 2019/3/10.
 */
@Data
public class GoodsRecommendedListRsp {

    private Long goodsId;

    private String title;

    private String titleCaptions;

    private String goodsName;

    private BigDecimal goodsPrice;

    private String goodsImg;
}
