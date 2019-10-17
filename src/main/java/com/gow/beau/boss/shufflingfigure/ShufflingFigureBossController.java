package com.gow.beau.boss.shufflingfigure;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureAddReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureEditReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigurePageReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureSetTimeReq;
import com.gow.beau.service.shufflingfigure.ShufflingFigureNumberService;
import com.gow.beau.service.shufflingfigure.ShufflingFigureService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName ShufflingFigureBossController
 * @Author lzn
 * @DATE 2019/9/23 10:08
 */
@Api(tags = "后台管理 - 轮播图管理")
@Controller
@RequestMapping("/shufflingFigureBoss")
public class ShufflingFigureBossController {


    @Autowired
    private ShufflingFigureService shufflingFigureService;

    @Autowired
    private ShufflingFigureNumberService shufflingFigureNumberService;

    /**
     * 轮播图管理 - 轮播图列表页面
     * */
    @RequestMapping("/shufflingFigure-list-page")
    public ModelAndView shufflingFigureListPage(){
        ModelAndView view = new ModelAndView("boss/shufflingfigure/shufflingFigureList");
        view.addObject("infoList",shufflingFigureNumberService.shufflingFigureNumberLit());
        return view;
    }


    /**
     * 轮播图管理 - 轮播图编辑页面
     * */
    @RequestMapping("/shufflingFigure-edit-page")
    public ModelAndView shufflingFigureEditPage(Long id){
        ModelAndView view = new ModelAndView("boss/shufflingfigure/shufflingFigureEdit");
        view.addObject("info",shufflingFigureService.getInfoById(id));
        return view;
    }


    /**
     * 轮播图管理 - 轮播图列表信息
     * */
    @RequestMapping("/shufflingFigurePage")
    @ResponseBody
    public PageInfo shufflingFigurePage(ShufflingFigurePageReq req){
        return shufflingFigureService.shufflingFigurePage(req);
    }


    /**
     * 新增
     * */
    @RequestMapping("/add")
    @ResponseBody
    public int add(ShufflingFigureAddReq req){
        return shufflingFigureService.add(req);
    }


    /**
     * 删除
     * */
    @RequestMapping("/del")
    @ResponseBody
    public int del(Long id){
        return shufflingFigureService.del(id);
    }


    /**
     * 设置 过期时间
     * */
    @RequestMapping("/validityTimeSet")
    @ResponseBody
    public int validityTimeSet(ShufflingFigureSetTimeReq req){
        return shufflingFigureService.validityTimeSet(req);
    }


    /**
     * 根据id 查询过期时间
     * */
    @RequestMapping("/getValidityTimeById")
    @ResponseBody
    public String getValidityTimeById(Long id){
        return shufflingFigureService.getValidityTimeById(id);
    }


    /**
     * 启用 或 禁用
     * */
    @RequestMapping("/isUseInfo")
    @ResponseBody
    public int isUseInfo(Long id){
        return shufflingFigureService.isUseInfo(id);
    }


    /**
     * 编辑
     * */
    @RequestMapping("/edit")
    @ResponseBody
    public int edit(ShufflingFigureEditReq req){
        return shufflingFigureService.edit(req);
    }

}
