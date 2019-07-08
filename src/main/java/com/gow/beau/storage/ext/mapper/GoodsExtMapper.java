package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.req.goods.SearchListReq;
import com.gow.beau.model.rsp.category.CategoryGoodsListRsp;
import com.gow.beau.model.rsp.goods.GoodsListRsp;
import com.gow.beau.model.rsp.goods.SearchListRsp;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.GoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsExtMapper {

    Goods selectByPrimaryKey(Long id);


    List<Goods> selectPageGoodsList();

    /**
     * @Author:lzn
     * @Date:2019/2/15 16:09
     */
    List<CategoryGoodsListRsp> selectCategoryGoodsListByCatId(@Param("categoryId") Long categoryId);

    /**
     * lzn 2019/3/11 9:25
     * 搜索列表
     */
    List<SearchListRsp> searchGoodsList(SearchListReq req);

    /**
     * 商品管理 - 商品列表
     * */
    List<GoodsListRsp> getGoodsList(GoodsListReq req);
}