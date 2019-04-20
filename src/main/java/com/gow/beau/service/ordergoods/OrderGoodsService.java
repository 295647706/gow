package com.gow.beau.service.ordergoods;

import com.gow.beau.model.rsp.order.OrderListGoodsRsp;
import com.gow.beau.storage.ext.mapper.OrderGoodsExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzn on 2019/3/12.
 */
@Service
public class OrderGoodsService {

    @Autowired
    private OrderGoodsExtMapper orderGoodsExtMapper;

    /**
     * lzn 2019/3/12 17:15
     * 根据订单id 查询订单商品列表信息
     */
    public List<OrderListGoodsRsp> selectOrderGoodsListByOrderId(Long orderId) {
        return orderGoodsExtMapper.selectOrderGoodsListByOrderId(orderId);
    }

    /**
     * lzn 2019/3/29 12:36
     * 根据订单id查询商品名称
     */
    public String selectGoodsNamesByorderId(Long orderId) {
        return orderGoodsExtMapper.selectGoodsNamesByorderId(orderId);
    }
}
