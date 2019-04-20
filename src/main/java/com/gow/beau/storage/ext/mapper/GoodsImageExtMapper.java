package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.rsp.goods.GoodsImageRsp;
import com.gow.beau.storage.auto.model.GoodsImage;
import com.gow.beau.storage.auto.model.GoodsImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsImageExtMapper {

    /**
     * @Author:lzn
     * @Date:2019/2/15 15:03
     * 商品图片列表
     */
    List<GoodsImageRsp> selectGoodsImageListByGoodsId(Long goodsId);
}