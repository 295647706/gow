package com.gow.beau.model.req.shoppingcart;

import lombok.Data;

/**
 * Created by lzn on 2019/3/11.
 */
@Data
public class EditShoppingCartGoodsNumberReq {

    private Long shoppingCartId;

    private Integer goodsNumber;
}
