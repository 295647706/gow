package com.gow.beau.model.req.goods;

import lombok.Data;

/**
 * @ClassName GoodsDeleteReq
 * @Author lzn
 * @DATE 2019/7/9 17:16
 */
@Data
public class GoodsDeleteReq {

    //商品ids
    private Long[] goodsIds;
}
