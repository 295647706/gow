package com.gow.beau.model.data;

import lombok.Data;

/**
 * @ClassName PayMentZfm
 * @Author lzn
 * @DATE 2019/9/2 16:40
 * 支付猫 实体
 */
@Data
public class PayMentZfm {

    private String price;

    private String istype;

    private String orderid;

    private String orderuid;

    private String goodsname;

    private String uid;

    private String notifyUrl;

    private String returnUrl;

    private String baseUrl;

    private String key;
}
