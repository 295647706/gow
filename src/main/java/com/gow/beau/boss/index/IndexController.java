package com.gow.beau.boss.index;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lzn on 2019/6/25.
 */
@Api(tags = "后台管理 - 首页")
@Controller
@RequestMapping("/bossIndex")
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("boss/index/index");

        return view;
    }
}
