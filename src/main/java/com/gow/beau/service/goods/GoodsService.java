package com.gow.beau.service.goods;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.req.goods.SearchListReq;
import com.gow.beau.model.rsp.goods.GoodsDetailRsp;
import com.gow.beau.model.req.goods.GoodsDetailReq;
import com.gow.beau.model.rsp.goods.GoodsImageRsp;
import com.gow.beau.model.rsp.goods.GoodsListRsp;
import com.gow.beau.model.rsp.goods.SearchListRsp;
import com.gow.beau.service.collection.GoodsCollectionService;
import com.gow.beau.storage.auto.mapper.GoodsMapper;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.ext.mapper.GoodsExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/2/15 10:01<br/>
 *
 * @author lzn
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsExtMapper goodsExtMapper;

    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private GoodsCollectionService goodsCollectionService;

    /**
     * @Author:lzn
     * @Date:2019/2/15 10:03
     */
    public List<Goods> pageGoodsList() {
        List<Goods> goodsList = goodsExtMapper.selectPageGoodsList();
        if(goodsList == null){
            goodsList = new ArrayList<>();
        }
        return goodsList;
    }

    public GoodsDetailRsp goodsDetail(GoodsDetailReq req) {
        GoodsDetailRsp rsp = new GoodsDetailRsp();
        //商品信息
        Goods goods = goodsMapper.selectByPrimaryKey(req.getGoodsId());
        if(null == goods){
            throw new RuntimeException("没有此商品的信息");
        }

        //商品信息
        rsp.setId(goods.getId());
        rsp.setGoodsName(goods.getGoodsName());
        rsp.setGoodsDeno(goods.getGoodsDeno());
        rsp.setGoodsDetailDesc(goods.getGoodsDetailDesc());
        rsp.setGoodsNo(goods.getGoodsNo());
        rsp.setGoodsSpec(goods.getGoodsSpec());
        rsp.setGoodsPrice(goods.getGoodsPrice());
        rsp.setGoodsNumber(goods.getGoodsNumber());
        rsp.setGoodsDetailImg(goods.getGoodsDetailImg());

        //商品收藏信息
        if(null != req.getCustomerId()){
            int count = goodsCollectionService.selectCountBycustomerIdAndGoodsId(req.getCustomerId(),req.getGoodsId());
            if(count > 0){
                //已被收藏
                rsp.setIsGoodsCollection(true);
            }else{
                //未被收藏
                rsp.setIsGoodsCollection(false);
            }
        }

        //商品图片
        List<GoodsImageRsp> goodsImageRspList = goodsImageService.selectGoodsImageListByGoodsId(req.getGoodsId());
        rsp.setGoodsImageList(goodsImageRspList==null?new ArrayList<GoodsImageRsp>():goodsImageRspList);

        return rsp;
    }

    /**
     * lzn 2019/3/5 17:24
     * 商品信息
     */
    public Goods selectGoodsInfo(Long goodsId){
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    /**
     * lzn 2019/3/11 9:25
     * 搜索列表
     */
    public List<SearchListRsp> searchGoodsList(SearchListReq req) {
        List<SearchListRsp> rspList = goodsExtMapper.searchGoodsList(req);

        //如果没有数据则new 一个新对象，避免前端报错
        if(null == rspList || rspList.size() == 0){
            return null;
        }
        return rspList;
    }

    /**
     * 商品管理 - 商品列表
     * */
    public PageInfo getGoodsList(GoodsListReq req) {
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        //查询商品列表
        List<GoodsListRsp> rsps = goodsExtMapper.getGoodsList(req);
        pageInfo.setList(rsps);
        pageInfo.setRows(this.getGoodsRows(req));
        return pageInfo;
    }

    /**
     * 商品总数
     * */
    private int getGoodsRows(GoodsListReq req){
        return goodsExtMapper.goodsRows(req);
    }
}
