package com.gow.beau.api.html;

import com.gow.beau.api.goods.GoodsController;
import com.gow.beau.model.req.goods.GoodsDetailReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/15 14:19<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/goodsDetailPage")
public class GoodsDetailPageController {

    @Autowired
    private GoodsController goodsController;

    @RequestMapping("/goods-detail-page")
    public ModelAndView goodsDetailPage(GoodsDetailReq req){
        ModelAndView view = new ModelAndView("goods-detail/goods-detail");
        view.addObject("goodsDetail",goodsController.goodsDetail(req));
        return view;
    }
}
