package com.gow.beau.model.req.goodsrecommended;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * @ClassName GoodsRecommendedPageReq
 * @Author lzn
 * @DATE 2019/9/16 11:17
 */
@Data
public class GoodsRecommendedPageReq extends PageInfo {

    //商品名称
    private String goodsName;

    //品牌id
    private Long catId;

    //是否查询已删除的商品
    private int isDel;

}
