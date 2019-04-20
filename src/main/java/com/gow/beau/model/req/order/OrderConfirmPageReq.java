package com.gow.beau.model.req.order;

import lombok.Data;

import java.util.List;

/**
 * Created by lzn on 2019/3/5.
 */
@Data
public class OrderConfirmPageReq {

    private Long customerId;

    //立即购买的商品id
    private Long goodsId;

    //立即购买的商品数量
    private int goodsNumber;

    //购物车的商品id
    private List<Long> shoppingCartds;

}
