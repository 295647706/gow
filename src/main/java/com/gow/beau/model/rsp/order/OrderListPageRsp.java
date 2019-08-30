package com.gow.beau.model.rsp.order;

import com.gow.beau.storage.auto.model.Order;
import lombok.Data;

import java.util.List;

/**
 * @ClassName OrderListPageRsp
 * @Author lzn
 * @DATE 2019/8/27 17:49
 */
@Data
public class OrderListPageRsp extends Order {


    //订单商品列表
    private List<OrderListGoodsRsp> goodsRspList;
}
