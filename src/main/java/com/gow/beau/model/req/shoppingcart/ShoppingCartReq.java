package com.gow.beau.model.req.shoppingcart;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date: 2019/2/18 10:24<br/>
 *
 * @author lzn
 */
@Data
public class ShoppingCartReq {

    //会员id
    @NotNull(message = "会员id不能空")
    private Long customerId;
}
