package com.gow.beau.service.category;

import com.gow.beau.model.rsp.category.CategoryGoodsListRsp;
import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.storage.ext.mapper.CategoryExtMapper;
import com.gow.beau.storage.ext.mapper.GoodsExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/2/15 15:54<br/>
 *
 * @author lzn
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryExtMapper categoryExtMapper;

    @Autowired
    private GoodsExtMapper goodsExtMapper;

    public List<CategoryListRsp> categoryGoodsListAll() {
        //分类数据列表
        List<CategoryListRsp> categoryListRspList = this.getCategoryList();
        //当没有数据时处理
        if(categoryListRspList == null || categoryListRspList.size() == 0){
            //没有数据则设置一条空的数据返回
            categoryListRspList = new ArrayList<>();
            categoryListRspList.add(new CategoryListRsp());

            List<CategoryGoodsListRsp> categoryGoodsListRspList = new ArrayList<>();
            categoryGoodsListRspList.add(new CategoryGoodsListRsp());
            categoryListRspList.get(0).setCategoryGoodsListRspList(categoryGoodsListRspList);
            return categoryListRspList;
        }

        for(CategoryListRsp category : categoryListRspList){
            List<CategoryGoodsListRsp> categoryGoodsListRspList = goodsExtMapper.selectCategoryGoodsListByCatId(category.getCategoryId());
            category.setCategoryGoodsListRspList(categoryGoodsListRspList==null?new ArrayList<CategoryGoodsListRsp>():categoryGoodsListRspList);
        }
        return categoryListRspList;
    }

    /**
     * lzn 2019/3/11 8:23
     * 分类数量
     */
    public int categoryNumber() {
        return categoryExtMapper.categoryNumber();
    }

    /**
     * 分类信息
     * */
    public List<CategoryListRsp> getCategoryList(){
        return categoryExtMapper.categoryGoodsListAll();
    }
}
