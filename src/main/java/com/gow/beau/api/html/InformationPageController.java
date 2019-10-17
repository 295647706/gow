package com.gow.beau.api.html;

import com.gow.beau.api.information.InformationController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName InformationPageController
 * @Author lzn
 * @DATE 2019/9/18 17:49
 */
@Api(tags = "页面 - 资讯")
@Controller
@RequestMapping("/informationPage")
public class InformationPageController {

    @Autowired
    private InformationController informationController;


    /**
     * 资讯详情页面
     * */
    @RequestMapping("/information-detail-page")
    public ModelAndView informationDetailPage(Long informationId){
        ModelAndView view = new ModelAndView("information/informationDetail");
        view.addObject("info",informationController.getInformationDetail(informationId));
        return view;
    }

    /**
     * 资讯列表页面
     * */
    @RequestMapping("/information-list-page")
    public ModelAndView informationListPage(){
        ModelAndView view = new ModelAndView("information/informationList");
        return view;
    }
}
