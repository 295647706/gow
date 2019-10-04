package com.gow.beau.model.req.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lzn on 2019/3/19.
 */
@Data
public class PaymentOrderReq {

    //private Long orderId;

    private String orderCode;

    private String payType;

    //支付金额
    private BigDecimal payPrice;
}
