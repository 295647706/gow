package com.gow.beau.api.lxwm;

import com.gow.beau.model.rsp.lxwm.LxwmRsp;
import com.gow.beau.service.lxwm.ContactUSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lzn on 2019/3/25.
 */
@Controller
@RequestMapping("/contactUs")
public class ContactUSController {

    @Autowired
    private ContactUSService contactUSService;

    /**
     * lzn 2019/3/25 18:03
     * 联系列表
     */
    @RequestMapping("/lxwmList")
    public List<LxwmRsp> lxwmList(){
        return contactUSService.lxwmList();
    }

}
