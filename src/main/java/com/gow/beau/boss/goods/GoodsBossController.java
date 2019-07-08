package com.gow.beau.boss.goods;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.rsp.goods.GoodsListRsp;
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

    /**
     * 商品管理 - 商品列表页面
     * */
    @RequestMapping("/goods-list-page")
    public ModelAndView goodsList(){
        ModelAndView view = new ModelAndView("boss/goods/goodsList");
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
}
