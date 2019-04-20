package com.gow.beau.model.req.order;

import lombok.Data;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class OrderListReq {

    //会员id
    private Long customerId;

    //订单状态
    private String orderStatus;

    //订单评价状态
    private String evaluateFlag;

}
