package com.gow.beau.model.req.customer;

import lombok.Data;

/**
 * Date: 2019/2/18 15:12<br/>
 *
 * @author lzn
 */
@Data
public class EditCustomerInfoReq {

    private Long customerId;

    private String customerRealname;

    private String sex;

    private String address;
}
