package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberPageReq;
import com.gow.beau.storage.auto.model.ShufflingFigureNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShufflingFigureNumberExtMapper {

    List<ShufflingFigureNumber> shufflingFigureNumberPage(ShufflingFigureNumberPageReq req);

    List<ShufflingFigureNumber> shufflingFigureNumberLit();

    int shufflingFigureNumberPageCount(ShufflingFigureNumberPageReq req);

    Integer selectCountByType(String type);
}