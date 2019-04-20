package com.gow.beau.model.rsp.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class OrderListRsp {

    //订单id
    private Long orderId;

    //订单编号
    private String orderCode;

    //订单状态
    private String orderStatus;

    //运费
    private BigDecimal expressPrice;

    //总共商品数量
    private int sumGoodsNumber;

    //订单金额
    private BigDecimal orderPrice;

    //订单列表商品
    private List<OrderListGoodsRsp> orderListGoodsRsps;
}
