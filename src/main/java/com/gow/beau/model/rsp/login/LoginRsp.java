package com.gow.beau.model.rsp.login;

import lombok.Data;

/**
 * Created by lzn on 2019/2/28.
 */
@Data
public class LoginRsp {

    private Long customerId;

    private String customerUsername;

    private String customerPassword;
}
