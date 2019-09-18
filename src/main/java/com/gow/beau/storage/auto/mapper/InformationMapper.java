package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.Information;
import com.gow.beau.storage.auto.model.InformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationMapper {
    long countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExampleWithBLOBs(InformationExample example);

    List<Information> selectByExample(InformationExample example);

    Information selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExampleWithBLOBs(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKeyWithBLOBs(Information record);

    int updateByPrimaryKey(Information record);
}