package com.gow.common.exception;

import com.gow.common.result.Result;
import com.gow.common.result.ResultUtil;
import com.gow.common.web.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @ClassName ExceptionHandle
 * @Author lzn
 * @DATE 2019/11/14 10:29
 * 统一处理异常类
 */
@ControllerAdvice
public class ExceptionHandle {

    protected final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public static Result handle(Exception e){
        //判断异常是否是自定义异常
        if(e instanceof RestException){
            RestException rest = (RestException) e;
            return ResultUtil.error(rest.getMsg());
        }else{

            //操作数据库异常
            if(e instanceof SQLException){
                return ResultUtil.error("操作数据库异常",e);
            }

            //SQL语法错误
            if(e instanceof BadSqlGrammarException){
                return ResultUtil.error("SQL语法错误",e);
            }

            //空指针异常
            if(e instanceof NullPointerException){
                return ResultUtil.error("空指针异常",e);
            }

            //数组下标越界异常
            if(e instanceof  NumberFormatException){
                return ResultUtil.error("数组下标越界异常",e);
            }

            //数字格式化异常
            if(e instanceof  ArrayIndexOutOfBoundsException){
                return ResultUtil.error("数字格式化异常",e);
            }

            //解析异常
            if(e instanceof ParseException){
                return ResultUtil.error("解析异常",e);
            }

            //类型转换异常
            if(e instanceof ClassCastException){
                return ResultUtil.error("类型转换异常",e);
            }

            //数学运算异常
            if(e instanceof ArithmeticException){
                return ResultUtil.error("数学运算异常",e);
            }

            //文件未找到异常
            if(e instanceof FileNotFoundException){
                return ResultUtil.error("文件未找到异常",e);
            }

            //文件已结束异常
            if(e instanceof EOFException){
                return ResultUtil.error("文件已结束异常",e);
            }

            //输入输出异常
            if(e instanceof IOException){
                return ResultUtil.error("输入输出异常",e);
            }

            return ResultUtil.error(ResultStatus.UNKONW_ERROR.getMsg(),e);
        }
    }
}
