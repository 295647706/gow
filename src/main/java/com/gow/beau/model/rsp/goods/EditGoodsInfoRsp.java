package com.gow.beau.model.rsp.goods;

import com.gow.beau.storage.auto.model.Goods;
import lombok.Data;

/**
 * @ClassName EditGoodsInfoRsp
 * @Author lzn
 * @DATE 2019/7/10 11:38
 */
@Data
public class EditGoodsInfoRsp extends Goods {

    //品牌名称
    private String catName;

    private Long catId;
}
