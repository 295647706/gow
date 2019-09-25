package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.ShufflingFigureNumber;
import com.gow.beau.storage.auto.model.ShufflingFigureNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShufflingFigureNumberMapper {
    long countByExample(ShufflingFigureNumberExample example);

    int deleteByExample(ShufflingFigureNumberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShufflingFigureNumber record);

    int insertSelective(ShufflingFigureNumber record);

    List<ShufflingFigureNumber> selectByExample(ShufflingFigureNumberExample example);

    ShufflingFigureNumber selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShufflingFigureNumber record, @Param("example") ShufflingFigureNumberExample example);

    int updateByExample(@Param("record") ShufflingFigureNumber record, @Param("example") ShufflingFigureNumberExample example);

    int updateByPrimaryKeySelective(ShufflingFigureNumber record);

    int updateByPrimaryKey(ShufflingFigureNumber record);
}