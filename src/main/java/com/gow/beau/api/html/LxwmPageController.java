package com.gow.beau.api.html;

import com.gow.beau.api.lxwm.ContactUSController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lzn on 2019/3/25.
 */
@Controller
@RequestMapping("/lxwmPage")
public class LxwmPageController {

    @Autowired
    private ContactUSController contactUSController;

    /**
     * lzn 2019/3/25 17:41
     * 联系我们页面
     */
    @RequestMapping("/lxwm-page")
    public ModelAndView lxwmPage(){
        ModelAndView view = new ModelAndView("lxwm/lxwm");
        view.addObject("contactList",contactUSController.lxwmList());
        return view;
    }
}
