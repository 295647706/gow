package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.rsp.order.OrderGoodsDetailRsp;
import com.gow.beau.model.rsp.order.OrderListGoodsRsp;
import com.gow.beau.storage.auto.model.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsExtMapper {

    List<OrderListGoodsRsp> selectOrderGoodsListByOrderId(@Param("orderId") Long orderId);

    List<OrderGoodsDetailRsp> selectOrderGoodsDetailListByOrderId(@Param("orderId") Long orderId);

    /**
     * lzn 2019/3/29 12:36
     * 根据订单id查询商品名称
     */
    String selectGoodsNamesByorderId(@Param("orderId") Long orderId);
}