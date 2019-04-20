package com.gow.beau.api.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lzn on 2019/3/11.
 */
@Controller
@RequestMapping("search")
public class SearchPageController {

    @RequestMapping("/search-list-page")
    public ModelAndView searchListPage(){
        ModelAndView view = new ModelAndView("search/search-list");
        return view;
    }
}
