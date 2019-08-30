package com.gow.beau.model.req.order;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class OrderListReq extends PageInfo {

    //会员id
    private Long customerId;

    //订单状态
    private String orderStatus;

    //订单评价状态
    private String evaluateFlag;

    //订单号
    private String orderCode;

    //支付类型
    private String payType;

    //下单开始时间
    private String startTime;

    //下单结束时间
    private String endTime;

}
