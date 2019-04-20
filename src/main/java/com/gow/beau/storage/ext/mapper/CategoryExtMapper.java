package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.storage.auto.model.Category;
import com.gow.beau.storage.auto.model.CategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryExtMapper {

    List<CategoryListRsp> categoryGoodsListAll();

    /**
     * lzn 2019/3/11 8:23
     * 分类数量
     */
    int categoryNumber();
}