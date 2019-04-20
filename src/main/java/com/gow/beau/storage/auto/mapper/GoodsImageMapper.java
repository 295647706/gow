package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.GoodsImage;
import com.gow.beau.storage.auto.model.GoodsImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsImageMapper {
    long countByExample(GoodsImageExample example);

    int deleteByExample(GoodsImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsImage record);

    int insertSelective(GoodsImage record);

    List<GoodsImage> selectByExample(GoodsImageExample example);

    GoodsImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsImage record, @Param("example") GoodsImageExample example);

    int updateByExample(@Param("record") GoodsImage record, @Param("example") GoodsImageExample example);

    int updateByPrimaryKeySelective(GoodsImage record);

    int updateByPrimaryKey(GoodsImage record);
}