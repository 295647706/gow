package com.gow.beau.boss.goods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/4/21 0021.
 */
@Controller
@RequestMapping("/goodsBoss")
public class GoodsBossController {

    @RequestMapping("/goods-list-page")
    public ModelAndView goodsList(){
        ModelAndView view = new ModelAndView("boss/goods/goodsList");

        return view;
    }
}
