package com.gow.beau.model.rsp.order;

import lombok.Data;

import java.util.Date;

/**
 * Created by lzn on 2019/3/6.
 */
@Data
public class OrderConfirmAddressRsp {

    private Long id;

    private String addressName;

    private String addressProvince;

    private String addressCity;

    private String addressCounty;

    private String addressStreet;

    private String addressDetail;

    private String addressPhone;
}
