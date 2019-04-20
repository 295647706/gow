package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.GoodsCollection;
import com.gow.beau.storage.auto.model.GoodsCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCollectionMapper {
    long countByExample(GoodsCollectionExample example);

    int deleteByExample(GoodsCollectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCollection record);

    int insertSelective(GoodsCollection record);

    List<GoodsCollection> selectByExample(GoodsCollectionExample example);

    GoodsCollection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCollection record, @Param("example") GoodsCollectionExample example);

    int updateByExample(@Param("record") GoodsCollection record, @Param("example") GoodsCollectionExample example);

    int updateByPrimaryKeySelective(GoodsCollection record);

    int updateByPrimaryKey(GoodsCollection record);
}