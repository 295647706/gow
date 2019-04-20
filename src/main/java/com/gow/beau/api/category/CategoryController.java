package com.gow.beau.api.category;

import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Date: 2019/2/15 15:45<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categoryGoodsListAll")
    public List<CategoryListRsp> categoryGoodsListAll(){
        return categoryService.categoryGoodsListAll();
    }

    /**
     * lzn 2019/3/11 8:23
     * 分类数量
     */
    @RequestMapping("/categoryNumber")
    @ResponseBody
    public int categoryNumber(){
        return categoryService.categoryNumber();
    }
}
