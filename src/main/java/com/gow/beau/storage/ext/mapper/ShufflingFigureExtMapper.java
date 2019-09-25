package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.shufflingfigure.ShufflingFigurePageReq;
import com.gow.beau.storage.auto.model.ShufflingFigure;

import java.util.Date;
import java.util.List;

public interface ShufflingFigureExtMapper {

    List<ShufflingFigure> shufflingFigurePage(ShufflingFigurePageReq req);

    int shufflingFigurePageCount(ShufflingFigurePageReq req);

    Integer selectMaxSort();

    Date selectValidityTimeById(Long id);

}