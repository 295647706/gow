package com.gow.beau.model.req.goods;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * Created by lzn on 2019/6/26.
 */
@Data
public class GoodsListReq extends PageInfo {

    //商品名称
    private String goodsName;

    //品牌id
    private Long catId;
}
