package com.gow.beau.service.category;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.category.CategoryAddReq;
import com.gow.beau.model.req.category.CategoryEditReq;
import com.gow.beau.model.req.category.CategoryListPageReq;
import com.gow.beau.model.rsp.category.CategoryDetailPageRsp;
import com.gow.beau.model.rsp.category.CategoryGoodsListRsp;
import com.gow.beau.model.rsp.category.CategoryListPageRsp;
import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.service.goods.GoodsService;
import com.gow.beau.storage.auto.mapper.CategoryMapper;
import com.gow.beau.storage.auto.model.Category;
import com.gow.beau.storage.ext.mapper.CategoryExtMapper;
import com.gow.beau.storage.ext.mapper.GoodsExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import com.gow.common.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
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
    private CategoryMapper categoryMapper;

    @Autowired
    private GoodsExtMapper goodsExtMapper;

    @Autowired
    private GoodsService goodsService;

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



    /**
     * 品牌管理 - 品牌列表数据
     * */
    public PageInfo getCategoryListPage(CategoryListPageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        List<Category> categoryList = categoryExtMapper.getCategoryListPage(req);
        if(!CollectionUtils.isEmpty(categoryList)){
            List<CategoryListPageRsp> rspList = new ArrayList<>();
            for(Category category : categoryList){
                CategoryListPageRsp rsp = new CategoryListPageRsp();
                BeanUtil.copyProperties(category, rsp);
                rsp.setCreateTimeF(DateUtil.dateToString(category.getCreateTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));
                rspList.add(rsp);
            }
            pageInfo.setList(rspList);
            pageInfo.setRows(this.getCategoryPageRows(req));
        }
        return pageInfo;
    }

    /**
     * 分类管理列表总数
     * */
    private int getCategoryPageRows(CategoryListPageReq req){
        return categoryExtMapper.getCategoryPageRows(req);
    }

    /**
     * 新增品牌分类
     * */
    public int addCategory(CategoryAddReq req){
        //根据分类名称查询数据库是否已存在相同的
        int count = categoryExtMapper.selectCatByName(req.getCatName());
        if(count > 0){
            return -1;
        }
        //查询最大的排序
        Integer maxSort = categoryExtMapper.selectMaxSort();
        //保存对象
        Category category = new Category();
        category.setCatName(req.getCatName());
        category.setCatIsShow(req.getCatIsShow());
        category.setCreateTime(new Date());
        category.setCatSort(maxSort == null ? 0:maxSort+1);
        category.setCatDelflag("0");
        return categoryMapper.insertSelective(category);
    }


    /**
     * 删除品牌分类
     * */
    public int deleteCategory(Long catId){
        //查询商品是否存在修改的分类
        int goodsCount = goodsService.selectGoodsCountByCatId(catId);
        if(goodsCount > 0){
            return -1;
        }

        Category category = new Category();
        category.setId(catId);
        category.setCatDelflag("1");
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    /**
     * 停用品牌分类
     * */
    public int stopCategory(Long catId){
        Category entry = categoryMapper.selectByPrimaryKey(catId);
        if(null == entry){
            return -1;
        }

        Category category = new Category();
        category.setId(catId);
        //是否显示(0:显示，1：不显示)
        String isShow = "0";
        if(null != entry.getCatIsShow() && entry.getCatIsShow().equals("0")){
            isShow = "1";
        }
        category.setCatIsShow(isShow);
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    /**
     * 品牌分类信息详情
     * */
    public Category selectCategoryById(Long catId){
        Category category = categoryMapper.selectByPrimaryKey(catId);
        if(null == category){
            return new Category();
        }
        return category;
    }

    /**
     * 品牌管理 - 品牌编辑
     * */
    public int editCategory(CategoryEditReq req){
        Category category = new Category();
        category.setId(req.getCatId());
        category.setCatName(req.getCatName());
        category.setCatIsShow(req.getCatIsShow());
        category.setCatSort(req.getCatSort());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public CategoryDetailPageRsp categoryDetailPage(Long catId){
        CategoryDetailPageRsp rsp = new CategoryDetailPageRsp();

        Category category = categoryMapper.selectByPrimaryKey(catId);
        if(null == category){
            rsp.setCategoryGoodsListRspList(new ArrayList<>());
            return rsp;
        }

        BeanUtil.copyProperties(category, rsp);
        rsp.setCreateTimeF(DateUtil.dateToString(category.getCreateTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));

        //品牌分类相关的商品
        List<CategoryGoodsListRsp> goodsListRspList = goodsExtMapper.selectCategoryGoodsListByCatId(catId);
        if(CollectionUtils.isEmpty(goodsListRspList)){
            rsp.setCategoryGoodsListRspList(new ArrayList<>());
        }
        rsp.setCategoryGoodsListRspList(goodsListRspList);
        return rsp;
    }

}
