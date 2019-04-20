package com.gow.beau.model.rsp.order;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lzn on 2019/3/6.
 */
@Data
public class OrderConfirmPageRsp {

    //商品列表
    private List<OrderConfirmGoodsRsp> orderConfirmGoodsRspList;

    //收货地址
    private OrderConfirmAddressRsp orderConfirmAddressRsp;

    //商品总数量
    private Integer goodsSumNumber;

    //商品总金额
    private BigDecimal sumPrice;

    //运费
    private Integer expressPrice;
}
