package com.gow.beau.model.req.shoppingcart;

import lombok.Data;

/**
 * Created by lzn on 2019/3/5.
 */
@Data
public class AddShoppingCartReq {

    private Long goodsId;

    private Integer number;

    private Long customerId;
}
