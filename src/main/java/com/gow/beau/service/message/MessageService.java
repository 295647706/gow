package com.gow.beau.service.message;

import com.gow.beau.model.rsp.message.PageMessageListRsp;
import com.gow.beau.storage.ext.mapper.MessageExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzn on 2019/3/10.
 */
@Service
public class MessageService {

    @Autowired
    private MessageExtMapper messageExtMapper;

    public List<PageMessageListRsp> pageMessageList() {
        List<PageMessageListRsp> rspList = messageExtMapper.pageMessageList();

        //如果没有列表信息，则new一个新的对象，避免前端报错
        if(null == rspList || rspList.size() == 0){
            rspList = new ArrayList<>();
            PageMessageListRsp rsp = new PageMessageListRsp();
            rspList.add(rsp);
            return rspList;
        }

        return rspList;
    }
}
