package com.gow.beau.service.goods;

import com.gow.beau.model.rsp.goods.GoodsImageRsp;
import com.gow.beau.storage.ext.mapper.GoodsImageExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date: 2019/2/15 14:59<br/>
 *
 * @author lzn
 */
@Service
public class GoodsImageService {

    @Autowired
    private GoodsImageExtMapper goodsImageExtMapper;


    /**
     * @Author:lzn
     * @Date:2019/2/15 15:03
     * 商品图片列表
     */
    public List<GoodsImageRsp> selectGoodsImageListByGoodsId(Long goodsId) {
        return goodsImageExtMapper.selectGoodsImageListByGoodsId(goodsId);
    }

    /**
     * 根据商品id删除商品图片
     * */
    public int deleteGoodsImageByGoodsId(Long goodsId){
        return goodsImageExtMapper.deleteGoodsImageByGoodsId(goodsId);
    }
}
