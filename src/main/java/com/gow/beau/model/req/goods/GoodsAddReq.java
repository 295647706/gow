package com.gow.beau.model.req.goods;

import com.gow.beau.storage.auto.model.Goods;
import lombok.Data;

/**
 * @ClassName GoodsAddReq
 * @Author lzn
 * @DATE 2019/7/10 16:54
 */
@Data
public class GoodsAddReq extends Goods {

    //商品图片(多张图片用英文','隔开)
    private String goodsImgs;

    //商品详情图片(多张图片用英文','隔开)
    private String goodsDetailImgs;

    //推荐标题
    private String goodsRecommendedTitle;

    //推荐标题说明
    private String goodsRecommendedTitleCaptions;
}
