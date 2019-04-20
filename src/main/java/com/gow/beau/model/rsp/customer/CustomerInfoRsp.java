package com.gow.beau.model.rsp.customer;

import lombok.Data;

import java.util.Date;

/**
 * Created by lzn on 2019/3/18.
 */
@Data
public class CustomerInfoRsp {

    private Long customerId;

    private String customerUsername;

    private String customerNickname;

    private String customerRealname;

    private String customerImg;

    private String sex;

    //会员等级
    private String customerLevel = "普通会员";
}
