package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.information.InformationListPageReq;
import com.gow.beau.model.rsp.information.InformationListPageRsp;
import com.gow.beau.storage.auto.model.Information;
import com.gow.beau.storage.auto.model.InformationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationExtMapper {


    List<Information> informationListPage(InformationListPageReq req);

    int informationListPageCount(InformationListPageReq req);

    Integer selectCountTitle(@Param("title") String title,@Param("id") Long id);

}