package com.gow.beau.api.html;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/18 11:34<br/>
 *
 * @author lzn
 */
@Api(tags = "页面 - 关于我们")
@Controller
@RequestMapping("/aboutPage")
public class AboutPageController {

    @RequestMapping("/about-page")
    public ModelAndView aboutPage(){
        ModelAndView view = new ModelAndView("about/about");
        return view;
    }

}
