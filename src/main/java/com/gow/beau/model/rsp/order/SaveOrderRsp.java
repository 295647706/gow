package com.gow.beau.model.rsp.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lzn on 2019/3/12.
 */
@Data
public class SaveOrderRsp {

    private String orderCode;

    private BigDecimal orderPrice;
}
