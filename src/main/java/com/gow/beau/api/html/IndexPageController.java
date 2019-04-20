package com.gow.beau.api.html;

import com.gow.beau.api.goods.GoodsController;
import com.gow.beau.api.goodsrecommended.GoodsRecommendedController;
import com.gow.beau.api.message.MessageController;
import com.gow.beau.autowired.CheckToken;
import com.gow.beau.autowired.LoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/15 11:17<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/indexPage")
public class IndexPageController {

    @Autowired
    private GoodsController goodsController;

    @Autowired
    private GoodsRecommendedController goodsRecommendedController;

    @Autowired
    private MessageController messageController;

    @RequestMapping("/index-page")
    public ModelAndView indexPage(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("goodsList",goodsController.pageGoodsList());
        view.addObject("goodsRecommendedList",goodsRecommendedController.pageGoodsRecommendedList());
        view.addObject("messageList",messageController.pageMessageList());
        return view;
    }

    @RequestMapping("/index-page2")
    public ModelAndView indexPage2(){
        ModelAndView view = new ModelAndView("index2");
        view.addObject("goodsList",goodsController.pageGoodsList());
        view.addObject("goodsRecommendedList",goodsRecommendedController.pageGoodsRecommendedList());
        view.addObject("messageList",messageController.pageMessageList());
        return view;
    }

    @RequestMapping("/checkToken")
    //@CheckToken
    public ModelAndView checkToken(){
        ModelAndView view = new ModelAndView("error");
        return view;
    }
}
