package com.gow.beau.model.rsp.customer;

import lombok.Data;

import java.util.Date;

/**
 * Date: 2019/2/18 15:46<br/>
 *
 * @author lzn
 */
@Data
public class CustomerAddressListRsp {

    private Long id;

    private String addressName;

    private String addressProvince;

    private String addressCity;

    private String addressCounty;

    private String addressStreet;

    private String addressDetail;

    private String addressPhone;

    private String isDefault;
}
