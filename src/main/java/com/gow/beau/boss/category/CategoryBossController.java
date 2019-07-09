package com.gow.beau.boss.category;

import com.gow.beau.model.rsp.category.CategoryListRsp;
import com.gow.beau.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName CategoryBossController
 * @Author lzn
 * @DATE 2019/7/9 15:41
 * 后台分类
 */
@Controller
@RequestMapping("/categoryBoss")
public class CategoryBossController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分类信息
     * */
    @RequestMapping("/getCategoryList")
    @ResponseBody
    public List<CategoryListRsp> getCategoryList(){
        return categoryService.getCategoryList();
    }
}
