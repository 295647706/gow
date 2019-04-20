package com.gow.beau.model.rsp.customer;

import lombok.Data;

import java.util.Date;

/**
 * Date: 2019/2/18 14:18<br/>
 *
 * @author lzn
 */
@Data
public class CustomerRsp {

    private Long customerId;

    private String customerUsername;

    private String customerNickname;

    private String customerRealname;

    private String customerImg;

    private String sex;

    private Date birthday;

    private String address;

    private String mobile;

}
