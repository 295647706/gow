package com.gow.beau.storage.ext.mapper;

import com.gow.beau.storage.auto.model.GoodsDetailImage;
import com.gow.beau.storage.auto.model.GoodsDetailImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDetailImageExtMapper {

    List<GoodsDetailImage> selectListByGoodsId(Long goodsId);
}