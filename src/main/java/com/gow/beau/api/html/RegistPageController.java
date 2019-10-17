package com.gow.beau.api.html;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lzn on 2019/3/19.
 */
@Api(tags = "页面 - 注册")
@Controller
@RequestMapping("/registPage")
public class RegistPageController {

    /**
     * lzn 2019/3/19 14:13
     * 注册页面
     */
    @RequestMapping("/regist-page")
    public ModelAndView registPage(){
        ModelAndView view = new ModelAndView("regist/regist");
        return view;
    }

    @RequestMapping("/xieyi")
    public ModelAndView xieyi(){
        ModelAndView view = new ModelAndView("regist/xieyi");
        return view;
    }
}
