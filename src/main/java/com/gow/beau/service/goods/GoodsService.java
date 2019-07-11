package com.gow.beau.service.goods;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goods.GoodsAddReq;
import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.req.goods.SearchListReq;
import com.gow.beau.model.rsp.goods.*;
import com.gow.beau.model.req.goods.GoodsDetailReq;
import com.gow.beau.service.collection.GoodsCollectionService;
import com.gow.beau.storage.auto.mapper.GoodsImageMapper;
import com.gow.beau.storage.auto.mapper.GoodsMapper;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.GoodsImage;
import com.gow.beau.storage.ext.mapper.GoodsExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private GoodsImageMapper goodsImageMapper;

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

    /**
     * 删除商品
     * */
    public int deleteGoods(Long[] goodsIds) {
        if(goodsIds.length > 0){
            int count = 0;
            for(Long goodsId : goodsIds){
                count += goodsExtMapper.deleteGoodsByGoodsId(goodsId);
            }
            return count;
        }
        return 0;
    }

    /**
     * 编辑商品的查询详情
     * */
    public EditGoodsInfoRsp getEditGoodsInfo(Long goodsId) {
        if(null != goodsId){
            return goodsExtMapper.getEditGoodsInfoBygoodsId(goodsId);
        }
        return null;
    }

    /**
     * 新增商品
     * */
    public int addGoods(GoodsAddReq req) {
        String[] goodsImgs = null;
        Goods goods = new Goods();
        BeanUtil.copyProperties(req,goods);
        goods.setGoodsNo(CodeUtil.goodsCode());
        if(null == goods.getGoodsScore()){
            goods.setGoodsScore(new BigDecimal(90));
        }
        goods.setGoodsDetailImg(req.getGoodsDetailImgs());

        //商品图片处理
        if (null != req.getGoodsImgs() && !req.getGoodsImgs().equals("")) {
            goodsImgs = req.getGoodsImgs().split(",");
            if (goodsImgs != null && goodsImgs.length == 1) {
                goodsImgs = req.getGoodsImgs().split("，");
            }
            if (goodsImgs != null && goodsImgs.length == 1) {
                goodsImgs = req.getGoodsImgs().split(";");
            }
            if (goodsImgs != null && goodsImgs.length == 1) {
                goodsImgs = req.getGoodsImgs().split("；");
            }
            //商品图片
            if(null != goodsImgs && goodsImgs.length >0){
                goods.setGoodsImg(goodsImgs[0]);
            }
        }

        //保存商品信息
        int count = goodsMapper.insertSelective(goods);
        if(count > 0) {
            //保存
            if (null != goodsImgs && goodsImgs.length > 0) {
                for (String imgUrl : goodsImgs) {
                    GoodsImage goodsImage = new GoodsImage();
                    goodsImage.setGoodsId(goods.getId());
                    goodsImage.setImageUrl(imgUrl);
                    goodsImageMapper.insertSelective(goodsImage);
                }
            }
        }
        
        return count;
    }
}
