package com.gow.beau.boss.goods;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goods.GoodsAddReq;
import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.rsp.goods.EditGoodsInfoRsp;
import com.gow.beau.service.category.CategoryService;
import com.gow.beau.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2019/4/21 0021.
 */
@Controller
@RequestMapping("/goodsBoss")
public class GoodsBossController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 商品管理 - 商品列表页面
     * */
    @RequestMapping("/goods-list-page")
    public ModelAndView goodsList(){
        ModelAndView view = new ModelAndView("boss/goods/goodsList");
        view.addObject("categoryList",categoryService.getCategoryList());
        return view;
    }

    /**
     * 商品管理 - 商品列表
     * */
    @RequestMapping("/goodsList")
    @ResponseBody
    public PageInfo getGoodsList(GoodsListReq req){
        return goodsService.getGoodsList(req);
    }

    /**
     * 删除商品
     * */
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public int deleteGoods(Long[] goodsIds){
        return goodsService.deleteGoods(goodsIds);
    }

    /**
     * 编辑商品的查询详情
     * */
    @RequestMapping("/getEditGoodsInfo")
    @ResponseBody
    public EditGoodsInfoRsp getEditGoodsInfo(Long goodsId){
        return goodsService.getEditGoodsInfo(goodsId);
    }

    /**
     * 商品管理 - 商品列表页面
     * */
    @RequestMapping("/goods-add-page")
    public ModelAndView goodsAddPage(){
        ModelAndView view = new ModelAndView("boss/goods/goodsAdd");
        view.addObject("categoryList",categoryService.getCategoryList());
        return view;
    }

    /**
     * 新增商品
     * */
    @RequestMapping("/addGoods")
    @ResponseBody
    public int addGoods(GoodsAddReq req){
        return goodsService.addGoods(req);
    }
}
