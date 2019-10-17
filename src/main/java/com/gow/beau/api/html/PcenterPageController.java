package com.gow.beau.api.html;

import com.gow.beau.autowired.CheckToken;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/18 10:15<br/>
 *
 * @author lzn
 */
@Api(tags = "页面 - 个人中心")
@Controller
@RequestMapping("/pcenterPage")
public class PcenterPageController {

    @RequestMapping("/pcenter-page")
    @CheckToken
    public ModelAndView pcenterPage(){
        ModelAndView view = new ModelAndView("pcenter/pcenter");
        return view;
    }

    @RequestMapping("/pcenter2-page")
    @CheckToken
    public ModelAndView pcenter2Page(){
        ModelAndView view = new ModelAndView("pcenter/new/pcenter2");
        return view;
    }
}
