package com.gow.beau.model.req.order;

import lombok.Data;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class SaveOrderGoodsReq {

    private Long goodsId;

    private Long shoppingCartId;

    private int goodsNumber;
}
