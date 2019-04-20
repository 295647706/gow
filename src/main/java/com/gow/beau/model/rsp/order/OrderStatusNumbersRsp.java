package com.gow.beau.model.rsp.order;

import lombok.Data;

/**
 * Created by lzn on 2019/3/14.
 */
@Data
public class OrderStatusNumbersRsp {

    //待付款
    private Integer paymentStatusNumber;

    //待发货
    private Integer sendGoodsStatusNumber;

    //待收货
    private Integer theGoodsStatusNumber;

    //待评价
    private Integer evaluateStatusNumber;

}
