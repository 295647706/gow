package com.gow.beau.service.payment;

import com.gow.beau.storage.auto.model.Payment;
import com.gow.beau.storage.ext.mapper.PaymentExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PaymentService
 * @Author lzn
 * @DATE 2019/8/16 15:16
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentExtMapper paymentExtMapper;

    public Payment selectFirstPaymentInfo(){
        return paymentExtMapper.selectFirstPaymentInfo();
    }
}
