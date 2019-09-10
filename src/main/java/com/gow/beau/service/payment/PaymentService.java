package com.gow.beau.service.payment;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.payment.PayMentAddEditReq;
import com.gow.beau.model.req.payment.PayMentListReq;
import com.gow.beau.model.rsp.payment.PayTypeListRsp;
import com.gow.beau.storage.auto.mapper.PaymentMapper;
import com.gow.beau.storage.auto.model.Payment;
import com.gow.beau.storage.ext.mapper.PaymentExtMapper;
import com.gow.beau.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PaymentService
 * @Author lzn
 * @DATE 2019/8/16 15:16
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentExtMapper paymentExtMapper;

    @Autowired
    private PaymentMapper paymentMapper;

    public Payment selectFirstPaymentInfo(String useType){
        return paymentExtMapper.selectFirstPaymentInfo(useType);
    }

    /**
     * 支付通道配置信息 - 列表数据
     * */
    public PageInfo getPayListPage(PayMentListReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        //查询列表
        List<Payment> paymentList = paymentExtMapper.getPayListPage(req);
        if(!CollectionUtils.isEmpty(paymentList)){
            for(Payment payment : paymentList){
                if(null != payment.getUseType()){
                    //(docpay:支付猫，pufpay：个人收款)
                    if(payment.getUseType().equals("docpay")){
                        payment.setUseType("支付猫");
                    }else if(payment.getUseType().equals("docpay")){
                        payment.setUseType("个人收款");
                    }
                }
                payment.setUid(payment.getUid()==null?"无":payment.getUid());
            }
        }

        pageInfo.setList(paymentList);
        pageInfo.setRows(this.getPayRows(req));

        return pageInfo;
    }

    /**
     * 支付通道配置信息 - 总行数
     * */
    private int getPayRows(PayMentListReq req){
        return paymentExtMapper.getPayRows(req);
    }


    /**
     * 新增支付信息
     * */
    public int addPayInfo(PayMentAddEditReq req){
        if(this.getCountByUseType(req.getUseType()) > 0){
            return -1;
        }
        Payment payment = new Payment();
        BeanUtil.copyProperties(req,payment);
        return paymentMapper.insertSelective(payment);
    }

    /**
     * 支付信息详情
     * */
    public Payment getPaymentById(Long payId){
        return paymentMapper.selectByPrimaryKey(payId);
    }

    /**
     * 编辑支付信息
     * */
    public int editPayInfo(PayMentAddEditReq req){
        Payment payment = new Payment();
        BeanUtil.copyProperties(req,payment);
        return paymentMapper.updateByPrimaryKeySelective(payment);
    }

    /**
     * 根据商户类型判断查询数量
     * */
    private int getCountByUseType(String useType){
        return paymentExtMapper.getCountByUseType(useType);
    }

    /**
     * 删除支付信息
     * */
    public int deletePayInfo(Long payId){
        return paymentMapper.deleteByPrimaryKey(payId);
    }
}
