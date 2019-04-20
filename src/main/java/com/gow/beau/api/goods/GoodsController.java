package com.gow.beau.api.goods;

import com.gow.beau.model.req.goods.SearchListReq;
import com.gow.beau.model.rsp.goods.GoodsDetailRsp;
import com.gow.beau.model.req.goods.GoodsDetailReq;
import com.gow.beau.model.rsp.goods.SearchListRsp;
import com.gow.beau.service.goods.GoodsService;
import com.gow.beau.storage.auto.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Date: 2019/2/15 10:00<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * @Author:lzn
     * @Date:2019/2/15 10:03
     */
    @RequestMapping("/pageGoodsList")
    public List<Goods> pageGoodsList(){
        return goodsService.pageGoodsList();
    }

    @RequestMapping("/goodsDetail")
    public GoodsDetailRsp goodsDetail(GoodsDetailReq req){
        return goodsService.goodsDetail(req);
    }

    /**
     * lzn 2019/3/11 9:25
     * 搜索列表
     */
    @RequestMapping("/searchGoodsList")
    @ResponseBody
    public List<SearchListRsp> searchGoodsList(SearchListReq req){
        return goodsService.searchGoodsList(req);
    }

}
