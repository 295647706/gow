package com.gow.beau.api.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/18 14:11<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/customerEditPasswordPage")
public class CustomerEditPasswordPageController {

    @RequestMapping("/customer-edit-password-page")
    public ModelAndView customerEditPasswordPage(){
        ModelAndView view = new ModelAndView("customer/password-edit");
        return view;
    }
}
