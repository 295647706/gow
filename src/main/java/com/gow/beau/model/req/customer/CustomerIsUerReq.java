package com.gow.beau.model.req.customer;

import lombok.Data;

/**
 * @ClassName CustomerIsUerReq
 * @Author lzn
 * @DATE 2019/8/30 13:41
 */
@Data
public class CustomerIsUerReq {

    private Long customerId;

    private String isUse;
}
