package com.gow.common.exception;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常处理
 * @ClassName RestException
 * @Author lzn
 * @DATE 2019/11/13 15:14
 */
@Data
public class RestException extends RuntimeException {

    protected Logger logger = LoggerFactory.getLogger(RestException.class);

    private Integer code = -2;
    private String msg;
    private String error;

    public RestException(Exception e){
        super(e.getMessage());
        this.setError(e);
    }

    public RestException(String msg){
        super(msg);
        this.msg = msg;
    }

    public RestException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RestException(String msg,Exception e){
        super(msg);
        this.msg = msg;
        this.setError(e);
    }

    private void setError(Exception e){
        logger.error("系统异常：",e);
        e.printStackTrace();
    }
}
