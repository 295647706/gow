package com.gow.beau.model.req.goods;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date: 2019/2/15 14:40<br/>
 *
 * @author lzn
 */
@Data
public class GoodsDetailReq {

    @NotNull(message = "商品id不能空")
    private Long goodsId;

    private Long customerId;
}
