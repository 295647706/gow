package com.gow.beau.api.html;

import com.gow.beau.api.goods.GoodsController;
import com.gow.beau.api.goodsrecommended.GoodsRecommendedController;
import com.gow.beau.api.information.InformationController;
import com.gow.beau.api.message.MessageController;
import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedListRsp;
import com.gow.beau.service.shufflingfigure.ShufflingFigureService;
import com.gow.beau.storage.auto.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @Autowired
    private InformationController informationController;

    @Autowired
    public ShufflingFigureService shufflingFigureService;

    @RequestMapping("/index-page")
    public ModelAndView indexPage(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("newpage","100S");
        view.addObject("goodsList",goodsController.pageGoodsList());
        view.addObject("goodsRecommendedList",goodsRecommendedController.pageGoodsRecommendedList());
        //view.addObject("messageList",messageController.pageMessageList());
        view.addObject("informationList",informationController.pageInformationList());
        view.addObject("shufflingFigureList",shufflingFigureService.shufflingFigureList("1"));
        return view;
    }

    @RequestMapping("/index-page2")
    public ModelAndView indexPage2(){
        ModelAndView view = new ModelAndView("index2");
        view.addObject("goodsList",goodsController.pageGoodsList());
        view.addObject("goodsRecommendedList",goodsRecommendedController.pageGoodsRecommendedList());
        //view.addObject("messageList",messageController.pageMessageList());
        view.addObject("informationList",informationController.pageInformationList());
        return view;
    }

    @RequestMapping("/checkToken")
    //@CheckToken
    public ModelAndView checkToken(){
        ModelAndView view = new ModelAndView("error");
        return view;
    }


    /**
     * 商品列表信息
     * */
    @RequestMapping("/getPageGoodsList")
    @ResponseBody
    public PageInfo getPageGoodsList(PageInfo pageInfo){
        pageInfo.setList(goodsController.pageGoodsList());
        return pageInfo;
    }


    /**
     * 推荐 商品列表信息
     * */
    @RequestMapping("/getPageGoodsRecommendedList")
    @ResponseBody
    public List<GoodsRecommendedListRsp> getPageGoodsRecommendedList(){
        return goodsRecommendedController.pageGoodsRecommendedList();
    }

    /**
     * 资讯 列表信息
     * */
    @RequestMapping("/getPageInformationList")
    @ResponseBody
    public List<Information> getPageInformationList(){
        return informationController.pageInformationList();
    }
}
