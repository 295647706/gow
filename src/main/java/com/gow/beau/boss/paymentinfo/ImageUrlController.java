package com.gow.beau.boss.paymentinfo;

import com.gow.beau.service.imageurl.ImageUrlService;
import com.gow.beau.storage.auto.model.ImageUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName ImageUrlController
 * @Author lzn
 * @DATE 2019/9/12 16:18
 * 图片存储路径设置
 */
@Controller
@RequestMapping("/imageUrlBoss")
public class ImageUrlController {

    @Autowired
    private ImageUrlService imageUrlService;

    /**
     * 支付配置 - 列表页面
     * */
    @RequestMapping("/imageurl-page")
    public ModelAndView imageurlPage(){
        ModelAndView view = new ModelAndView("boss/basicinfo/imageurl/imageurlView");
        view.addObject("imageurl",imageUrlService.getImageUrl());
        return view;
    }


    /**
     * 新增或修改
     * */
    @RequestMapping("/updateAddUrl")
    @ResponseBody
    public int updateAddUrl(ImageUrl imageUrl){
        return imageUrlService.updateAddUrl(imageUrl);
    }

}
