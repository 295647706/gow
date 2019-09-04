package com.gow.beau.model.rsp.order;

import lombok.Data;

/**
 * @ClassName PayMentZfmRsp
 * @Author lzn
 * @DATE 2019/9/2 17:23
 */
@Data
public class PayMentZfmRsp {

    private String orderCode;

    private String payType;
}
