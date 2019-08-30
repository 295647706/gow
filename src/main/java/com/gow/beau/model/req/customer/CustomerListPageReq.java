package com.gow.beau.model.req.customer;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * @ClassName CustomerListPageReq
 * @Author lzn
 * @DATE 2019/8/29 17:58
 */
@Data
public class CustomerListPageReq extends PageInfo {

    private String customerUsername;

    private String customerRealname;

    private String isUse;

    private String sex;

    //下单开始时间
    private String startTime;

    //下单结束时间
    private String endTime;
}
