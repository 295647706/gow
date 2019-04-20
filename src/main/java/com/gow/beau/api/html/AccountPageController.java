package com.gow.beau.api.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/18 11:18<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/accountPage")
public class AccountPageController {

    @RequestMapping("/account-page")
    public ModelAndView accountPage(){
        ModelAndView view = new ModelAndView("customer/account");
        return view;
    }
}
