package com.gow.beau.model.rsp.shoppingcart;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Date: 2019/2/18 10:28<br/>
 *
 * @author lzn
 */
@Data
public class ShoppingCartGoodsListRsp {

    private Long shoppingCartId;

    private Long goodsId;

    private String goodsName;

    private String goodsSpec;

    private String goodsNo;

    private BigDecimal goodsPrice;

    private String goodsDeno;

    private Integer goodsNumber;

    private String goodsImage;

}
