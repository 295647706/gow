package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.GoodsRecommended;
import com.gow.beau.storage.auto.model.GoodsRecommendedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsRecommendedMapper {
    long countByExample(GoodsRecommendedExample example);

    int deleteByExample(GoodsRecommendedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsRecommended record);

    int insertSelective(GoodsRecommended record);

    List<GoodsRecommended> selectByExample(GoodsRecommendedExample example);

    GoodsRecommended selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsRecommended record, @Param("example") GoodsRecommendedExample example);

    int updateByExample(@Param("record") GoodsRecommended record, @Param("example") GoodsRecommendedExample example);

    int updateByPrimaryKeySelective(GoodsRecommended record);

    int updateByPrimaryKey(GoodsRecommended record);
}