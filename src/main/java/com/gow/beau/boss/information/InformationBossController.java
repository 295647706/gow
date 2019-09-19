package com.gow.beau.boss.information;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.information.InformationListPageReq;
import com.gow.beau.service.information.InformationService;
import com.gow.beau.storage.auto.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName InformationController
 * @Author lzn
 * @DATE 2019/9/16 16:18
 */
@Controller
@RequestMapping("/informationBoss")
public class InformationBossController {

    @Autowired
    private InformationService informationService;

    /**
     * 资讯管理 - 列表页面
     * */
    @RequestMapping("/information-list-page")
    public ModelAndView informationList(){
        ModelAndView view = new ModelAndView("boss/information/informationList");
        return view;
    }

    /**
     * 资讯管理 - 列表数据
     * */
    @RequestMapping("informationListPage")
    @ResponseBody
    public PageInfo informationListPage(InformationListPageReq req){
        return informationService.informationListPage(req);
    }


    /**
     * 资讯管理 - 新增页面
     * */
    @RequestMapping("/information-add-page")
    public ModelAndView informationAdd(){
        ModelAndView view = new ModelAndView("boss/information/informationAdd");
        return view;
    }

    /**
     * 新增
     * */
    @RequestMapping("/add")
    @ResponseBody
    public int add(Information information){
        return informationService.add(information);
    }


    /**
     * 删除
     * */
    @RequestMapping("/del")
    @ResponseBody
    private int del(Long id){
        return informationService.del(id);
    }

    /**
     * 资讯管理 - 编辑页面
     * */
    @RequestMapping("/information-edit-page")
    public ModelAndView informationEdit(Long id){
        ModelAndView view = new ModelAndView("boss/information/informationEdit");
        view.addObject("info",informationService.getInfo(id));
        return view;
    }


    /**
     * 编辑
     * */
    @RequestMapping("/edit")
    @ResponseBody
    public int edit(Information information){
        return informationService.edit(information);
    }


    /**
     * 草稿 或 发布
     * */
    @RequestMapping("/infoIssue")
    @ResponseBody
    public int infoIssue(Long id){
        return informationService.infoIssue(id);
    }


    /**
     * 资讯管理 - 编辑页面
     * */
    @RequestMapping("/information-view-page")
    public ModelAndView informationView(Long id){
        ModelAndView view = new ModelAndView("boss/information/informationView");
        view.addObject("info",informationService.getInfo(id));
        return view;
    }

}
