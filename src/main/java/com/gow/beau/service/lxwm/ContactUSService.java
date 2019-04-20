package com.gow.beau.service.lxwm;

import com.gow.beau.model.rsp.lxwm.LxwmRsp;
import com.gow.beau.storage.ext.mapper.ContactUSExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzn on 2019/3/25.
 */
@Service
public class ContactUSService {

    @Autowired
    private ContactUSExtMapper contactUSExtMapper;

    /**
     * lzn 2019/3/25 18:03
     * 联系列表
     */
    public List<LxwmRsp> lxwmList() {
        return contactUSExtMapper.lxwmList();
    }
}
