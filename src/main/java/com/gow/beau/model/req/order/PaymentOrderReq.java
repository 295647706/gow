package com.gow.beau.model.req.order;

import lombok.Data;

/**
 * Created by lzn on 2019/3/19.
 */
@Data
public class PaymentOrderReq {

    //private Long orderId;

    private String orderCode;

    private String payType;

    //支付回调orderid
    private String orderid;
}
