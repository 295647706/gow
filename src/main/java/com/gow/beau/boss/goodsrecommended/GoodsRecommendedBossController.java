package com.gow.beau.boss.goodsrecommended;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goodsrecommended.GoodsRecommendedEditReq;
import com.gow.beau.model.req.goodsrecommended.GoodsRecommendedPageReq;
import com.gow.beau.service.category.CategoryService;
import com.gow.beau.service.goodsrecommended.GoodsRecommendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName GoodsRecommendedController
 * @Author lzn
 * @DATE 2019/9/16 10:09
 */
@Controller
@RequestMapping("/goodsRecommendedBoss")
public class GoodsRecommendedBossController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsRecommendedService goodsRecommendedService;

    /**
     * 商品管理 - 推荐商品列表页面
     * */
    @RequestMapping("/goodsRecommended-list-page")
    public ModelAndView goodsRecommendedListPage(){
        ModelAndView view = new ModelAndView("boss/goodsrecommended/goodsRecommendedList");
        view.addObject("categoryList",categoryService.getCategoryList());
        return view;
    }

    /**
     * 商品管理 - 推荐商品列表
     * */
    @RequestMapping("/getGoodsRecommendedPage")
    @ResponseBody
    public PageInfo getGoodsRecommendedPage(GoodsRecommendedPageReq req){
        return goodsRecommendedService.getGoodsRecommendedPage(req);
    }


    /**
     * 删除
     * */
    @RequestMapping("/deleteGoodsRecommendedById")
    @ResponseBody
    public int deleteGoodsRecommendedById(Long goodsRecommendedId){
        return goodsRecommendedService.deleteGoodsRecommendedById(goodsRecommendedId);
    }


    /**
     * 商品管理 - 推荐商品列表页面
     * */
    @RequestMapping("/goodsRecommended-edit-page")
    public ModelAndView goodsRecommendedEditPage(Long goodsRecommendedId){
        ModelAndView view = new ModelAndView("boss/goodsrecommended/goodsRecommendedEdit");
        view.addObject("goods",goodsRecommendedService.selectGoodsRecommendedById(goodsRecommendedId));
        return view;
    }



    /**
     * 编辑
     * */
    @RequestMapping("/editGoodsRecommendedById")
    @ResponseBody
    public int editGoodsRecommendedById(GoodsRecommendedEditReq req){
        return goodsRecommendedService.editGoodsRecommendedById(req);
    }
}
