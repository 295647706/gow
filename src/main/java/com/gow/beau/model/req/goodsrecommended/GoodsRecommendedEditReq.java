package com.gow.beau.model.req.goodsrecommended;

import lombok.Data;

/**
 * @ClassName GoodsRecommendedEditReq
 * @Author lzn
 * @DATE 2019/9/16 15:31
 */
@Data
public class GoodsRecommendedEditReq {

    private Long goodsRecommendedId;

    private String title;

    private String titleCaptions;

}
