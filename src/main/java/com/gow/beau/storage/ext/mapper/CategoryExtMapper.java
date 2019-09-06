package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.category.CategoryListPageReq;
import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.storage.auto.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryExtMapper {

    List<CategoryListRsp> categoryGoodsListAll();

    /**
     * lzn 2019/3/11 8:23
     * 分类数量
     */
    int categoryNumber();

    /**
     * 品牌管理 - 品牌列表数据
     * */
    List<Category> getCategoryListPage(CategoryListPageReq req);

    /**
     * 品牌管理 - 品牌列表总数量
     * */
    int getCategoryPageRows(CategoryListPageReq req);

    int selectCatByName(String catName);

    Integer selectMaxSort();
}