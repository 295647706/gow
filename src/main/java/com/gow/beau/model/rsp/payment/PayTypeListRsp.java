package com.gow.beau.model.rsp.payment;

import com.gow.beau.storage.auto.model.Paytype;
import lombok.Data;

/**
 * @ClassName PayTypeListRsq
 * @Author lzn
 * @DATE 2019/9/10 12:33
 */
@Data
public class PayTypeListRsp extends Paytype {

    private String createTimeF;
}
