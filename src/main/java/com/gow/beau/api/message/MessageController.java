package com.gow.beau.api.message;

import com.gow.beau.model.rsp.message.PageMessageListRsp;
import com.gow.beau.service.message.MessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lzn on 2019/3/10.
 */
@Api(tags = "数据 - 消息")
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/pageMessageList")
    public List<PageMessageListRsp> pageMessageList(){
        return messageService.pageMessageList();
    }
}
