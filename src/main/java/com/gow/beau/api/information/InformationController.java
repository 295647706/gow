package com.gow.beau.api.information;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.information.InformationListPageReq;
import com.gow.beau.model.rsp.information.InformationRsp;
import com.gow.beau.service.information.InformationService;
import com.gow.beau.storage.auto.model.Information;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName InformationController
 * @Author lzn
 * @DATE 2019/9/18 17:30
 */
@Api(tags = "数据 - 资讯")
@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;


    /**
     * 首页资讯列表
     * 查询前10条
     * */
    public List<Information> pageInformationList(){
        return informationService.pageInformationList();
    }


    /**
     * 资讯列表-分页
     * */
    @RequestMapping("/selectInfoformationPage")
    @ResponseBody
    public PageInfo selectInfoformationPage(HttpServletRequest request,InformationListPageReq req){
        return informationService.selectInfoformationPage(request,req);
    }



    /**
     * 首页资讯详情
     * */
    public InformationRsp getInformationDetail(Long id){
        //修改阅读量
        informationService.updateToViewNumberById(id);
        //查询详情
        return informationService.getInfo(id);
    }


    /**
     * 点赞
     * */
    @RequestMapping("/toPraiseNumber")
    @ResponseBody
    public int toPraiseNumber(HttpServletRequest request,Long id){
        return informationService.toPraiseNumber(request,id);
    }

    /**
     * 关注
     * */
    @RequestMapping("/toFocusOn")
    @ResponseBody
    public int toFocusOn(HttpServletRequest request, Long id){
        return informationService.toFocusOn(request,id);
    }

    /**
     * 是否已关注
     * */
    @RequestMapping("/toFoucsBtn")
    @ResponseBody
    public int toFoucsBtn(HttpServletRequest request, Long id){
        return informationService.toFoucsBtn(request,id);
    }
}
