package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.payment.PayMentListReq;
import com.gow.beau.storage.auto.model.Payment;
import com.gow.beau.storage.auto.model.PaymentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentExtMapper {

    //查询一条信息
    Payment selectFirstPaymentInfo(String useType);

    List<Payment> getPayListPage(PayMentListReq req);

    int getPayRows(PayMentListReq req);

    int getCountByUseType(String useType);
}