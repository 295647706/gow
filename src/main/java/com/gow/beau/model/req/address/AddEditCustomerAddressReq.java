package com.gow.beau.model.req.address;

import lombok.Data;

/**
 * Date: 2019/2/19 10:47<br/>
 *
 * @author lzn
 */
@Data
public class AddEditCustomerAddressReq {

    private Long customerId;

    private Long addressId;

    private String addressName;

    private String addressPhone;

    private String addressDetail;

    private String isDefault;

    private String addressProvince;

    private String addressCity;

    private String addressCounty;

    private String addressStreet;

    private String addressTelephone;

    private String addressEmail;

    private String address;
}
