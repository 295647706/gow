package com.gow.beau.api.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/18 11:28<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/collectionPage")
public class CollectionPageController {

    @RequestMapping("/collection-page")
    public ModelAndView collectionPage(){
        ModelAndView view = new ModelAndView("collection/collection");
        return view;
    }
}
