package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.payment.PayTypeListReq;
import com.gow.beau.storage.auto.model.Paytype;

import java.util.List;

public interface PaytypeExtMapper {

    List<Paytype> getPaytypeAll();

    List<Paytype> getPayTypeListPage(PayTypeListReq req);

    List<Paytype> selectPayTypeList();

    int updateIsDefaultByAll();
}