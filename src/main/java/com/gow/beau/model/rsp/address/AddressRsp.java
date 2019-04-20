package com.gow.beau.model.rsp.address;

import lombok.Data;

/**
 * Date: 2019/2/18 16:42<br/>
 *
 * @author lzn
 */
@Data
public class AddressRsp {

    private Long id;

    private Long customerId;

    private String addressName;

    private String addressProvince;

    private String addressCity;

    private String addressCounty;

    private String addressStreet;

    private String addressDetail;

    private String addressPhone;

    private String isDefault;
}
