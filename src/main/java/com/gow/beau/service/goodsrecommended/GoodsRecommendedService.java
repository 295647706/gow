package com.gow.beau.service.goodsrecommended;

import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedListRsp;
import com.gow.beau.service.goods.GoodsService;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.GoodsRecommended;
import com.gow.beau.storage.ext.mapper.GoodsRecommendedExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzn on 2019/3/10.
 */
@Service
public class GoodsRecommendedService {

    @Autowired
    private GoodsRecommendedExtMapper goodsRecommendedExtMapper;

    @Autowired
    private GoodsService goodsService;


    /**
     * lzn 2019/3/10 14:13
     * 推荐列表
     */
    public List<GoodsRecommendedListRsp> pageGoodsRecommendedList() {
        List<GoodsRecommendedListRsp> rspList = new ArrayList<>();
        List<GoodsRecommended> goodsRecommendedList = goodsRecommendedExtMapper.pageGoodsRecommendedList();

        //如果没有信息则返回new 一个对象返回，避免签订报错
        if(null == goodsRecommendedList || goodsRecommendedList.size() == 0){
            rspList.add(new GoodsRecommendedListRsp());
            return rspList;
        }

        for(GoodsRecommended goodsRecommended : goodsRecommendedList){
            Goods goods = goodsService.selectGoodsInfo(goodsRecommended.getGoodsId());
            if(null != goods) {
                GoodsRecommendedListRsp rsp = new GoodsRecommendedListRsp();
                rsp.setTitle(goodsRecommended.getTitle());
                rsp.setTitleCaptions(goodsRecommended.getTitleCaptions());
                rsp.setGoodsId(goods.getId());
                rsp.setGoodsName(goods.getGoodsName());
                rsp.setGoodsPrice(goods.getGoodsPrice());
                rsp.setGoodsImg(goods.getGoodsImg());

                rspList.add(rsp);
            }

        }

        return rspList;
    }
}
