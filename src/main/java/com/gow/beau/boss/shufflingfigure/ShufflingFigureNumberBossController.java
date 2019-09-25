package com.gow.beau.boss.shufflingfigure;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberAddReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberEditReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberPageReq;
import com.gow.beau.model.rsp.shufflingfigure.ShufflingFigureNumberRsp;
import com.gow.beau.service.shufflingfigure.ShufflingFigureNumberService;
import com.gow.beau.storage.auto.model.ShufflingFigureNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName ShufflingFigureNumberBossController
 * @Author lzn
 * @DATE 2019/9/23 11:13
 */
@Controller
@RequestMapping("/shufflingFigureNumberBoss")
public class ShufflingFigureNumberBossController {

    @Autowired
    private ShufflingFigureNumberService shufflingFigureNumberService;

    /**
     * 轮播图管理 - 轮播图设置页面
     * */
    @RequestMapping("/shufflingFigure-number-set-page")
    public ModelAndView shufflingFigureSetPage(){
        ModelAndView view = new ModelAndView("boss/shufflingfigure/shufflingFigureSet");
        return view;
    }

    /**
     * 轮播图管理 - 轮播图设置列表 - 分页
     * */
    @RequestMapping("/shufflingFigureNumberPage")
    @ResponseBody
    public PageInfo shufflingFigureNumberPage(ShufflingFigureNumberPageReq req){
        return shufflingFigureNumberService.shufflingFigureNumberPage(req);
    }

    /**
     * 轮播图管理 - 轮播图设置列表 - 不分页
     * */
    @RequestMapping("/shufflingFigureNumberList")
    @ResponseBody
    public List<ShufflingFigureNumberRsp> shufflingFigureNumberLit(){
        return shufflingFigureNumberService.shufflingFigureNumberLit();
    }

    /**
     * 新增
     * */
    @RequestMapping("/add")
    @ResponseBody
    public int add(ShufflingFigureNumberAddReq req){
        return shufflingFigureNumberService.add(req);
    }

    /**
     * 删除
     * */
    @RequestMapping("/del")
    @ResponseBody
    public int del(Integer id){
        return shufflingFigureNumberService.del(id);
    }

    /**
     * 编辑
     * */
    @RequestMapping("/edit")
    @ResponseBody
    public int edit(ShufflingFigureNumberEditReq req){
        return shufflingFigureNumberService.edit(req);
    }

    /**
     * 启用 或 不启用
     * */
    @RequestMapping("/isUse")
    @ResponseBody
    public int isUse(Integer id){
        return shufflingFigureNumberService.isUse(id);
    }


    /**
     * 轮播图设置数量
     * */
    @RequestMapping("/getNumber")
    @ResponseBody
    public int getNumber(Integer id){
        return shufflingFigureNumberService.getNumber(id);
    }
}
