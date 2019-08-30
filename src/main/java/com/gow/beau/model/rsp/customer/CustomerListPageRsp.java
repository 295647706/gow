package com.gow.beau.model.rsp.customer;

import com.gow.beau.storage.auto.model.Customer;
import lombok.Data;

/**
 * @ClassName CustomerListPageRsp
 * @Author lzn
 * @DATE 2019/8/29 18:01
 */
@Data
public class CustomerListPageRsp extends Customer {

    //生日
    private String birthdayF;

    //创建时间
    private String createTimeF;
}
