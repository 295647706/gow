package com.gow.beau.model.rsp.upload;

import lombok.Data;

import java.util.List;

/**
 * @ClassName UploadRsp
 * @Author lzn
 * @DATE 2019/9/12 11:59
 */
@Data
public class UploadRsp {

    private int code;

    private String msg;

    private String data;

    private String path;
}
