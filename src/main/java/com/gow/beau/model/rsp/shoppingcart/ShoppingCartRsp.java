package com.gow.beau.model.rsp.shoppingcart;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Date: 2019/2/18 10:26<br/>
 *
 * @author lzn
 */
@Data
public class ShoppingCartRsp {

    //购物车总计
    private BigDecimal shopCartSumPrice;

    //购物车商品列表
    private List<ShoppingCartGoodsListRsp> shoppingCartGoodsListRsp;
}
