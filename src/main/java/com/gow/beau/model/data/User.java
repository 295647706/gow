package com.gow.beau.model.data;

import lombok.Data;

/**
 * Created by lzn on 2019/3/3.
 */
@Data
public class User {

    private Long id;

    private String userName;

    private String passWord;

    private String token;
}
