package com.gow.beau.storage.ext.mapper;

import com.gow.beau.storage.auto.model.GoodsCollection;
import com.gow.beau.storage.auto.model.GoodsCollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCollectionExtMapper {


    int selectCountBycustomerIdAndGoodsId(@Param("customerId") Long customerId, @Param("goodsId") Long goodsId);

    /**
     * lzn 2019/3/13 8:53
     * 商品收藏列表
     */
    List<GoodsCollection> selectGoodsCollectionListBycustomerId(@Param("customerId") Long customerId);
}