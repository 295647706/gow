package com.gow.beau.api.information;

import com.gow.beau.model.rsp.information.InformationRsp;
import com.gow.beau.service.information.InformationService;
import com.gow.beau.storage.auto.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName InformationController
 * @Author lzn
 * @DATE 2019/9/18 17:30
 */
@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;


    /**
     * 首页资讯列表
     * */
    public List<Information> pageInformationList(){
        return informationService.pageInformationList();
    }

    /**
     * 首页资讯详情
     * */
    public InformationRsp getInformationDetail(Long id){
        //修改阅读量
        informationService.updateToViewNumberById(id);
        return informationService.getInfo(id);
    }

}
