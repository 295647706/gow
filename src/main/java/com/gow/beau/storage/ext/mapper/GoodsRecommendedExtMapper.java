package com.gow.beau.storage.ext.mapper;

import com.gow.beau.storage.auto.model.GoodsRecommended;
import com.gow.beau.storage.auto.model.GoodsRecommendedExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsRecommendedExtMapper {

    List<GoodsRecommended> pageGoodsRecommendedList();
}