package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.rsp.message.PageMessageListRsp;

import java.util.List;

public interface MessageExtMapper {

    List<PageMessageListRsp> pageMessageList();
}