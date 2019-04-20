package com.gow.beau.model.req.regist;

import lombok.Data;

/**
 * Created by lzn on 2019/3/19.
 */
@Data
public class RegistUsernameReq {

    private String username;

    private String password;

    private String ip;
}
