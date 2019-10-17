package com.gow.beau.api.html;

import com.gow.beau.api.category.CategoryController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/15 15:39<br/>
 *
 * @author lzn
 */
@Api(tags = "页面 - 分类")
@Controller
@RequestMapping("/categoryPage")
public class CategoryPageController {

    @Autowired
    private CategoryController categoryController;

    @RequestMapping("/category-page")
    public ModelAndView categoryPage(){
        ModelAndView view = new ModelAndView("goods-category/goods-category");
        view.addObject("categoryGoodsList",categoryController.categoryGoodsListAll());
        return view;
    }
}
