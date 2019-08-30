package com.gow.beau.api.collection;

import com.gow.beau.model.req.collection.AddGoodsCollectionReq;
import com.gow.beau.model.req.collection.CollectionGoodsReq;
import com.gow.beau.model.req.collection.GoodsCollectionListReq;
import com.gow.beau.model.rsp.collection.GoodsCollectionListRsp;
import com.gow.beau.service.collection.GoodsCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lzn on 2019/3/5.
 */
@Controller
@RequestMapping("/goodsCollection")
public class GoodsCollectionController {

    @Autowired
    private GoodsCollectionService goodsCollectionService;

    /**
     * lzn 2019/3/5 17:18
     * 商品收藏
     */
    @RequestMapping("/addGoodsCollection")
    @ResponseBody
    public int addGoodsCollection(HttpServletRequest request,AddGoodsCollectionReq req){
        return goodsCollectionService.addGoodsCollection(request,req);
    }

    /**
     * lzn 2019/3/13 8:53
     * 商品收藏列表
     */
    @RequestMapping("/goodsCollectionList")
    @ResponseBody
    public List<GoodsCollectionListRsp> goodsCollectionList(HttpServletRequest request,GoodsCollectionListReq req){
        return goodsCollectionService.goodsCollectionList(request,req);
    }

    /**
     * lzn 2019/3/19 8:45
     * 根据登陆会员和商品id查询此商品是否被收藏
     */
    @RequestMapping("/isCollectionGoods")
    @ResponseBody
    public boolean isCollectionGoods(HttpServletRequest request, CollectionGoodsReq req){
        return goodsCollectionService.isCollectionGoods(request,req);
    }

    /**
     * 删除收藏信息
     */
    @RequestMapping("/deleteGoodsCollection")
    @ResponseBody
    public int deleteGoodsCollection(HttpServletRequest request,Long collectionId){
        return goodsCollectionService.deleteGoodsCollection(request,collectionId);
    }

}
