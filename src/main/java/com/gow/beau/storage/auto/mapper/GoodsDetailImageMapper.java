package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.GoodsDetailImage;
import com.gow.beau.storage.auto.model.GoodsDetailImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDetailImageMapper {
    long countByExample(GoodsDetailImageExample example);

    int deleteByExample(GoodsDetailImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsDetailImage record);

    int insertSelective(GoodsDetailImage record);

    List<GoodsDetailImage> selectByExample(GoodsDetailImageExample example);

    GoodsDetailImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsDetailImage record, @Param("example") GoodsDetailImageExample example);

    int updateByExample(@Param("record") GoodsDetailImage record, @Param("example") GoodsDetailImageExample example);

    int updateByPrimaryKeySelective(GoodsDetailImage record);

    int updateByPrimaryKey(GoodsDetailImage record);
}