package com.gow.beau.service.goods;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.goods.GoodsAddReq;
import com.gow.beau.model.req.goods.GoodsListReq;
import com.gow.beau.model.req.goods.SearchListReq;
import com.gow.beau.model.rsp.goods.*;
import com.gow.beau.model.req.goods.GoodsDetailReq;
import com.gow.beau.service.collection.GoodsCollectionService;
import com.gow.beau.storage.auto.mapper.GoodsDetailImageMapper;
import com.gow.beau.storage.auto.mapper.GoodsImageMapper;
import com.gow.beau.storage.auto.mapper.GoodsMapper;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.GoodsDetailImage;
import com.gow.beau.storage.auto.model.GoodsImage;
import com.gow.beau.storage.ext.mapper.GoodsDetailImageExtMapper;
import com.gow.beau.storage.ext.mapper.GoodsExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gow.beau.service.goodsrecommended.GoodsRecommendedService;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private GoodsRecommendedService goodsRecommendedService;

    @Autowired
    private GoodsDetailImageMapper goodsDetailImageMapper;

    @Autowired
    private GoodsDetailImageExtMapper goodsDetailImageExtMapper;

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
        rsp.setGoodsOldPrice(goods.getGoodsOldPrice());

        //详情图片
        List<GoodsDetailImage> goodsDetailImageList = goodsDetailImageExtMapper.selectListByGoodsId(goods.getId());
        if(!CollectionUtils.isEmpty(goodsDetailImageList)){
            List<String> imgs = new ArrayList<>();
            for(GoodsDetailImage image : goodsDetailImageList){
                imgs.add(image.getUrl());
            }
            rsp.setGoodsDetailImgs(imgs);
        }

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
        Goods goods = new Goods();
        BeanUtil.copyProperties(req,goods);
        goods.setGoodsNo(CodeUtil.goodsCode());
        if(null == goods.getGoodsScore()){
            goods.setGoodsScore(new BigDecimal(90));
        }
        goods.setGoodsDetailImg(req.getGoodsDetailImgs());

        //商品图片处理
        String[] goodsImgs = this.doGetGoodsImages(req.getGoodsImgs());
        //商品图片
        if(null != goodsImgs && goodsImgs.length >0){
            goods.setGoodsImg(goodsImgs[0]);
        }

        //创建时间
        goods.setCreateTime(new Date());
        //旧价格
        goods.setGoodsOldPrice(req.getGoodsOldPrice()==null?new BigDecimal(0):req.getGoodsOldPrice());
        //保存商品信息
        int count = goodsMapper.insertSelective(goods);
        if(count > 0) {
            //商品详情图片处理
            String[] goodsDetailImages = this.doGetGoodsImages(req.getGoodsDetailImgs());
            this.saveGoodsDetailImage(goods.getId(),goodsDetailImages);

            //保存商品图片
            this.saveGoodsImage(goods.getId(),goodsImgs);

            //推荐商品保存
            this.saveGoodsRecommended(goods.getId(),req);
        }
        return count;
    }

    /**
     * 商品图片处理
     * */
    private String[] doGetGoodsImages(String goodsImages){
        String[] goodsImgs = null;
        if (null != goodsImages && !goodsImages.equals("")) {
            goodsImgs = goodsImages.split(",");
            if (goodsImgs != null && goodsImgs.length == 1) {
                goodsImgs = goodsImages.split("，");
            }
            if (goodsImgs != null && goodsImgs.length == 1) {
                goodsImgs = goodsImages.split(";");
            }
            if (goodsImgs != null && goodsImgs.length == 1) {
                goodsImgs = goodsImages.split("；");
            }
        }
        return goodsImgs;
    }

    /**
     * 商品图片保存
     * */
    private int saveGoodsImage(Long goodsId,String[] goodsImgs){
        int count = 0;
        if (null != goodsImgs && goodsImgs.length > 0) {
            for (String imgUrl : goodsImgs) {
                GoodsImage goodsImage = new GoodsImage();
                goodsImage.setGoodsId(goodsId);
                goodsImage.setImageUrl(imgUrl);
                count += goodsImageMapper.insertSelective(goodsImage);
            }
        }
        return count;
    }

    /**
     * 商品详情图片保存
     * */
    private int saveGoodsDetailImage(Long goodsId,String[] images){
        int count = 0;
        if(null != images && images.length > 0){
            for(String img : images){
                GoodsDetailImage goodsDetailImage = new GoodsDetailImage();
                goodsDetailImage.setGoodsId(goodsId);
                goodsDetailImage.setUrl(img);
                count += goodsDetailImageMapper.insertSelective(goodsDetailImage);
            }
        }
        return count;
    }

    /**
     * 根据商品id删除商品图片
     * */
    private int deleteGoodsImageByGoodsId(Long goodsId){
        return goodsImageService.deleteGoodsImageByGoodsId(goodsId);
    }

    /**
     * 推荐商品保存
     * */
    private int saveGoodsRecommended(Long goodsId,GoodsAddReq req){
        //是否是推荐商品，如果是推荐商品则需要保存一份到推荐表中
        //是否推荐（0：未推荐，1：已推荐）
        if(!req.getIsRecommend().equals(null) && !req.getIsRecommend().equals("0")){
            return goodsRecommendedService.saveGoodsRecommended(goodsId,req.getGoodsRecommendedTitle(),req.getGoodsRecommendedTitleCaptions(),req.getIsRecommend());
        }
        return 0;
    }

    /**
     * 商品管理 - 商品编辑
     * */
    public int editGoods(GoodsAddReq req){
        Goods goods = new Goods();
        BeanUtil.copyProperties(req,goods);
        if(req.getGoodsDetailImgs() instanceof  String) {
            goods.setGoodsDetailImg(req.getGoodsDetailImgs());
        }

        //商品图片处理
        String[] goodsImgs = this.doGetGoodsImages(req.getGoodsImgs());
        //商品图片
        if(null != goodsImgs && goodsImgs.length >0){
            goods.setGoodsImg(goodsImgs[0]);
        }

        //修改商品信息
        //保存商品信息
        int count = goodsMapper.updateByPrimaryKeySelective(goods);
        if(count > 0){
            //商品详情图片处理
            String[] goodsDetailImages = this.doGetGoodsImages(req.getGoodsDetailImgs());
            this.saveGoodsDetailImage(goods.getId(),goodsDetailImages);

            //商品图片
            if(null != goodsImgs && goodsImgs.length >0){
                //把之前的商品图片删除
                goodsImageService.deleteGoodsImageByGoodsId(goods.getId());
            }
            //保存商品图片
            this.saveGoodsImage(goods.getId(),goodsImgs);

            //推荐商品保存
            this.saveGoodsRecommended(goods.getId(),req);
        }
        return count;
    }


    /**
     * 根据分类id 查询商品数量
     * */
    public int selectGoodsCountByCatId(Long catId){
        return goodsExtMapper.selectGoodsCountByCatId(catId);
    }
}
