package com.gow.beau.storage.ext.mapper;

import com.gow.beau.storage.auto.model.ShoppingCart;
import com.gow.beau.storage.auto.model.ShoppingCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartExtMapper {

    List<ShoppingCart> selectShoppingCartListByCustomerId(@Param("customerId") Long customerId);

    ShoppingCart selectShoppingCartByCustomerIdAndGoodsId(@Param("customerId") Long customerId, @Param("goodsId") Long goodsId);
}