package com.gow.beau.api.html;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lzn on 2019/3/11.
 */
@Api(tags = "页面 - 搜索")
@Controller
@RequestMapping("search")
public class SearchPageController {

    @RequestMapping("/search-list-page")
    public ModelAndView searchListPage(){
        ModelAndView view = new ModelAndView("search/search-list");
        return view;
    }
}
