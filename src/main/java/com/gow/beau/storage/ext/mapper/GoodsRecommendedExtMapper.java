package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.req.goodsrecommended.GoodsRecommendedPageReq;
import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedPageRsp;
import com.gow.beau.storage.auto.model.GoodsRecommended;
import com.gow.beau.storage.auto.model.GoodsRecommendedExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsRecommendedExtMapper {

    List<GoodsRecommended> pageGoodsRecommendedList();

    GoodsRecommended selectInfoByRecommendedType(String recommendedType);

    Integer selectMaxLevel();

    int deleteGoodsByGoodsId(Long goodsId);

    List<GoodsRecommendedPageRsp> getGoodsRecommendedPage(GoodsRecommendedPageReq req);

    int getGoodsRecommendedPageCount(GoodsRecommendedPageReq req);

    List<GoodsRecommendedPageRsp> getDelGoodsRecommendedPage();

    int getDelGoodsRecommendedPageCount();
}