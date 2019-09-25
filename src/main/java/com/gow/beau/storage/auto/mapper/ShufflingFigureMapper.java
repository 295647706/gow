package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.ShufflingFigure;
import com.gow.beau.storage.auto.model.ShufflingFigureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShufflingFigureMapper {
    long countByExample(ShufflingFigureExample example);

    int deleteByExample(ShufflingFigureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShufflingFigure record);

    int insertSelective(ShufflingFigure record);

    List<ShufflingFigure> selectByExample(ShufflingFigureExample example);

    ShufflingFigure selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShufflingFigure record, @Param("example") ShufflingFigureExample example);

    int updateByExample(@Param("record") ShufflingFigure record, @Param("example") ShufflingFigureExample example);

    int updateByPrimaryKeySelective(ShufflingFigure record);

    int updateByPrimaryKey(ShufflingFigure record);
}