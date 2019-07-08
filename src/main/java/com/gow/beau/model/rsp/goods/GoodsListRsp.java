package com.gow.beau.model.rsp.goods;

import com.gow.beau.storage.auto.model.Goods;
import lombok.Data;

/**
 * Created by lzn on 2019/6/26.
 */
@Data
public class GoodsListRsp extends Goods {

    //品牌名称
    private String catName;
}
