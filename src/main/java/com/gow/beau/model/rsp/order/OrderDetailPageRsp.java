package com.gow.beau.model.rsp.order;

import com.gow.beau.storage.auto.model.Order;
import com.gow.beau.storage.auto.model.OrderGoods;
import lombok.Data;

import java.util.List;

/**
 * @ClassName OrderDetailPageRsp
 * @Author lzn
 * @DATE 2019/8/29 11:13
 */
@Data
public class OrderDetailPageRsp extends Order {

    //订单商品详情列表
    private List<OrderGoodsDetailRsp> orderGoodsDetailRspList;
}
