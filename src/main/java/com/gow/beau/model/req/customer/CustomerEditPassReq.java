package com.gow.beau.model.req.customer;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName CustomerEditPassReq
 * @Author lzn
 * @DATE 2019/8/19 16:35
 */
@Data
public class CustomerEditPassReq {

    @NotNull(message = "请输入原始密码")
    private String oldpass;

    @NotNull(message = "请输入新密码")
    private String newpass1;

    @NotNull(message = "请输入确认密码")
    private String newpass2;
}
