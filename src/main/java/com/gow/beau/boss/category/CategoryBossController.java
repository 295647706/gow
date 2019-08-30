package com.gow.beau.boss.category;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.category.CategoryAddReq;
import com.gow.beau.model.req.category.CategoryListPageReq;
import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName CategoryBossController
 * @Author lzn
 * @DATE 2019/7/9 15:41
 * 后台分类
 */
@Controller
@RequestMapping("/categoryBoss")
public class CategoryBossController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分类信息
     * */
    @RequestMapping("/getCategoryList")
    @ResponseBody
    public List<CategoryListRsp> getCategoryList(){
        return categoryService.getCategoryList();
    }

    /**
     * 品牌管理 - 品牌列表页面
     * */
    @RequestMapping("/category-list-page")
    public ModelAndView categoryListPage(){
        ModelAndView view = new ModelAndView("boss/category/categoryList");
        return view;
    }


    /**
     * 品牌管理 - 品牌列表数据
     * */
    @RequestMapping("/categoryListPage")
    @ResponseBody
    public PageInfo getCategoryListPage(CategoryListPageReq req){
        return categoryService.getCategoryListPage(req);
    }

    /**
     * 品牌管理 - 品牌列表页面
     * */
    @RequestMapping("/category-add-page")
    public ModelAndView categoryAddPage(){
        ModelAndView view = new ModelAndView("boss/category/categoryAdd");
        return view;
    }

    /**
     * 新增品牌分类
     * */
    @RequestMapping("/addCategory")
    @ResponseBody
    public int addCategory(CategoryAddReq req){
        return categoryService.addCategory(req);
    }


    /**
     * 删除品牌分类
     * */
    @RequestMapping("/deleteCategory")
    @ResponseBody
    public int deleteCategory(Long catId){
        return categoryService.deleteCategory(catId);
    }

}
