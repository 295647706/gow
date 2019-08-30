package com.gow.beau.model.req.order;

import lombok.Data;

/**
 * @ClassName OrderExpressReq
 * @Author lzn
 * @DATE 2019/8/29 9:47
 */
@Data
public class OrderExpressReq {

    //订单id
    private Long orderId;

    //物流名称
    private String expressName;

    //物流单号
    private String expressCode;

}
