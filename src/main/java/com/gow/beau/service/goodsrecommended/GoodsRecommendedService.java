package com.gow.beau.service.goodsrecommended;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.req.goodsrecommended.GoodsRecommendedEditReq;
import com.gow.beau.model.req.goodsrecommended.GoodsRecommendedPageReq;
import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedListRsp;
import com.gow.beau.model.rsp.goodsrecommended.GoodsRecommendedPageRsp;
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
        recommended = new GoodsRecommended();
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


    /**
     * 删除推荐的商品
     * */
    public int deleteGoodsByGoodsId(Long goodsId){
        return goodsRecommendedExtMapper.deleteGoodsByGoodsId(goodsId);
    }


    /**
     * 商品管理 - 推荐商品列表
     * */
    public PageInfo getGoodsRecommendedPage(GoodsRecommendedPageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        if(req.getIsDel() == 1) {
            List<GoodsRecommendedPageRsp> rspList = goodsRecommendedExtMapper.getGoodsRecommendedPage(req);
            pageInfo.setList(rspList);
            pageInfo.setRows(this.getGoodsRecommendedPageCount(req));
        }else if(req.getIsDel() == 2){
            List<GoodsRecommendedPageRsp> rspList = goodsRecommendedExtMapper.getDelGoodsRecommendedPage();
            if(!CollectionUtils.isEmpty(rspList)){
                for(GoodsRecommendedPageRsp rsp : rspList){
                    Goods goods = goodsService.selectGoodsInfo(rsp.getGoodsId());
                    if(null != goods){
                        if(goods.getIsDelete().equals("1")){
                            //商品已被删除
                            rsp.setIsUse(1);
                        }else if(goods.getIsUpperLowerRacks().equals("0")){
                            //商品已下架
                            rsp.setIsUse(2);
                        }
                        rsp.setGoodsImg(goods.getGoodsImg());
                        rsp.setGoodsName(goods.getGoodsName());
                        rsp.setGoodsSpec(goods.getGoodsSpec());
                        rsp.setGoodsNumber(goods.getGoodsNumber());
                        rsp.setGoodsPrice(goods.getGoodsPrice());
                    }else{
                        rsp.setIsUse(-1);
                    }
                }
            }
            pageInfo.setList(rspList);
            pageInfo.setRows(this.getDelGoodsRecommendedPageCount());
        }

        return pageInfo;
    }


    /**
     * 商品管理 - 推荐商品列表总数量
     * */
    public int getGoodsRecommendedPageCount(GoodsRecommendedPageReq req){
        return goodsRecommendedExtMapper.getGoodsRecommendedPageCount(req);
    }

    /**
     * 商品管理 - 已删除商品列表总数量
     * */
    public int getDelGoodsRecommendedPageCount(){
        return goodsRecommendedExtMapper.getDelGoodsRecommendedPageCount();
    }


    /**
     * 删除
     * */
    public int deleteGoodsRecommendedById(Long goodsRecommendedId){
        return goodsRecommendedMapper.deleteByPrimaryKey(goodsRecommendedId);
    }


    public GoodsRecommendedPageRsp selectGoodsRecommendedById(Long goodsRecommendedId){
        GoodsRecommendedPageRsp rsp = new GoodsRecommendedPageRsp();
        GoodsRecommended goodsRecommended = goodsRecommendedMapper.selectByPrimaryKey(goodsRecommendedId);
        if(null == goodsRecommended){
            return rsp;
        }
        rsp.setGoodsRecommendedId(goodsRecommended.getId());
        rsp.setTitle(goodsRecommended.getTitle());
        rsp.setTitleCaptions(goodsRecommended.getTitleCaptions());
        rsp.setGoodsId(goodsRecommended.getGoodsId());

        //商品信息
        Goods goods = goodsService.selectGoodsInfo(goodsRecommended.getGoodsId());
        if(null != goods){
            rsp.setGoodsImg(goods.getGoodsImg());
            rsp.setGoodsName(goods.getGoodsName());
            rsp.setGoodsSpec(goods.getGoodsSpec());
            rsp.setGoodsNumber(goods.getGoodsNumber());
            rsp.setGoodsPrice(goods.getGoodsPrice());
        }
        return rsp;
    }


    /**
     * 编辑
     * */
    public int editGoodsRecommendedById(GoodsRecommendedEditReq req){
        GoodsRecommended goodsRecommended = goodsRecommendedMapper.selectByPrimaryKey(req.getGoodsRecommendedId());
        if(null == goodsRecommended){
            return 0;
        }
        goodsRecommended.setTitle(req.getTitle());
        goodsRecommended.setTitleCaptions(req.getTitleCaptions());
        return goodsRecommendedMapper.updateByPrimaryKeySelective(goodsRecommended);
    }
}
