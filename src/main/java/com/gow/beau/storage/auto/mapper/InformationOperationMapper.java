package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.InformationOperation;
import com.gow.beau.storage.auto.model.InformationOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationOperationMapper {
    long countByExample(InformationOperationExample example);

    int deleteByExample(InformationOperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InformationOperation record);

    int insertSelective(InformationOperation record);

    List<InformationOperation> selectByExample(InformationOperationExample example);

    InformationOperation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InformationOperation record, @Param("example") InformationOperationExample example);

    int updateByExample(@Param("record") InformationOperation record, @Param("example") InformationOperationExample example);

    int updateByPrimaryKeySelective(InformationOperation record);

    int updateByPrimaryKey(InformationOperation record);
}