package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.order.OrderListReq;
import com.gow.beau.storage.auto.model.Order;
import com.gow.beau.storage.auto.model.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderExtMapper {


    Long selectShoppingCartIdByCustomerId(@Param("customerId") Long customerId);

    List<Order> orderList(OrderListReq req);

    int orderStatusNumbers(@Param("customerId") Long customerId, @Param("orderStatus") String orderStatus, @Param("evaluateFlag") String evaluateFlag);

    /**
     * lzn 2019/3/19 15:28
     * 确认支付，去支付
     */
    int updateOrderStatusByOederCode(Order order);

    /**
     * lzn 2019/3/29 12:28
     * 根据订单编号（orderCode）查询订单信息
     */
    Order selectOrderByOederCode(String orderCode);

    /**
     * lzn 2019/3/31 15:31
     * 根据订单编号查询订单金额
     */
    BigDecimal selectOrderPriceByorderCode(@Param("orderCode") String orderCode);
}