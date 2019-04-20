package com.gow.beau.model.req.order;

import lombok.Data;

/**
 * Created by lzn on 2019/3/19.
 */
@Data
public class PaymentOrderReq {

    private Long orderId;

    private String orderCode;

    //支付类型(1:微信，2：支付宝)
    private String payType;
}
