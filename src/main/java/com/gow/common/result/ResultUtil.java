package com.gow.common.result;

import com.gow.common.web.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ResultUtil
 * @Author lzn
 * @DATE 2019/11/14 10:18
 * 统一返回工具类
 */
public class ResultUtil {

    protected final static Logger logger = LoggerFactory.getLogger(ResultUtil.class);

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS.getCode());
        result.setMsg(ResultStatus.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(String msg){
        return error(ResultStatus.UNKONW_ERROR.getCode(),msg);
    }

    public static Result error(String msg,Exception e){
        logger.error("\n"+msg+":",e);
        return error(ResultStatus.UNKONW_ERROR.getCode(),msg);
    }
}
