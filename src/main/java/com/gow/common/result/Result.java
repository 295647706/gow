package com.gow.common.result;

import lombok.Data;

/**
 * @ClassName Result
 * @Author lzn
 * @DATE 2019/11/14 10:16
 */
@Data
public class Result<T> {

    //错误代码
    private Integer code;
    //提示信息
    private String msg;
    //数据信息
    private T data;
}
