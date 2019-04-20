package com.gow.beau.model.req.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class SaveOrderReq {

    //会员id
    private Long customerId;

    //地址id
    private Long addressId;

    //快递方式
    private String expressWay;

    //订单留言
    private String orderMessage;

    //运费
    private BigDecimal expressPrice;

    //订单商品列表
    private List<SaveOrderGoodsReq> goodsReqs;
}
