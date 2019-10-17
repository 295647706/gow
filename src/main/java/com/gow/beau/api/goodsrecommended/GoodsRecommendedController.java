package com.gow.beau.api.goodsrecommended;

import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedListRsp;
import com.gow.beau.service.goodsrecommended.GoodsRecommendedService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lzn on 2019/3/10.
 */
@Api(tags = "数据 - 商品推荐")
@Controller
@RequestMapping("/goodsRecommended")
public class GoodsRecommendedController {

    @Autowired
    private GoodsRecommendedService goodsRecommendedService;

    /**
     * lzn 2019/3/10 14:13
     * 推荐列表
     */
    @RequestMapping("/pageGoodsRecommendedList")
    public List<GoodsRecommendedListRsp> pageGoodsRecommendedList(){
        return goodsRecommendedService.pageGoodsRecommendedList();
    }
}
