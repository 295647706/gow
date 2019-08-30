package com.gow.beau.service.goodsrecommended;

import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedListRsp;
import com.gow.beau.service.goods.GoodsService;
import com.gow.beau.storage.auto.mapper.GoodsRecommendedMapper;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.GoodsRecommended;
import com.gow.beau.storage.ext.mapper.GoodsRecommendedExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lzn on 2019/3/10.
 */
@Service
public class GoodsRecommendedService {

    @Autowired
    private GoodsRecommendedExtMapper goodsRecommendedExtMapper;

    @Autowired
    private GoodsRecommendedMapper goodsRecommendedMapper;

    @Autowired
    private GoodsService goodsService;

    /**
     * 保存推荐商品
     * */
    public int saveGoodsRecommended(Long goodsId,String title,String titleCaptions,String isRecommend){

        //根据推荐类型查询，如果数据库已经存在一个推荐类型了，则修改商品id
        GoodsRecommended recommended = goodsRecommendedExtMapper.selectInfoByRecommendedType(isRecommend);
        if(null != recommended){
            if(recommended.getGoodsId().longValue() == goodsId.longValue()){
                //相同商品id,则不需要改
                return 0;
            }
            recommended.setGoodsId(goodsId);
            recommended.setCreateTime(new Date());
            return goodsRecommendedMapper.updateByPrimaryKeySelective(recommended);
        }

        //找最大的层级,如果没有则默认：0
        Integer level = goodsRecommendedExtMapper.selectMaxLevel();
        if(null == level){
            level = 0;
        }
        //保存一条新的推荐商品
        recommended.setGoodsId(goodsId);
        recommended.setTitle(title);
        recommended.setTitleCaptions(titleCaptions);
        recommended.setIsDelete("0");
        recommended.setCreateTime(new Date());
        recommended.setLevel(level+1);
        recommended.setRecommendedType(isRecommend);
        return goodsRecommendedMapper.insert(recommended);
    }


    /**
     * lzn 2019/3/10 14:13
     * 推荐列表
     */
    public List<GoodsRecommendedListRsp> pageGoodsRecommendedList() {
        List<GoodsRecommendedListRsp> rspList = new ArrayList<>();
        List<GoodsRecommended> goodsRecommendedList = goodsRecommendedExtMapper.pageGoodsRecommendedList();

        //如果没有信息则返回new 一个对象返回，避免签订报错
        if(CollectionUtils.isEmpty(goodsRecommendedList)){
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
