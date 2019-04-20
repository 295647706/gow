package com.gow.beau.service.collection;

import com.auth0.jwt.JWT;
import com.gow.beau.model.req.collection.AddGoodsCollectionReq;
import com.gow.beau.model.req.collection.CollectionGoodsReq;
import com.gow.beau.model.req.collection.GoodsCollectionListReq;
import com.gow.beau.model.rsp.collection.GoodsCollectionListRsp;
import com.gow.beau.service.goods.GoodsService;
import com.gow.beau.storage.auto.mapper.GoodsCollectionMapper;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.GoodsCollection;
import com.gow.beau.storage.ext.mapper.GoodsCollectionExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lzn on 2019/3/5.
 */
@Service
public class GoodsCollectionService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCollectionMapper goodsCollectionMapper;

    @Autowired
    private GoodsCollectionExtMapper goodsCollectionExtMapper;

    /**
     * lzn 2019/3/5 17:18
     * 商品收藏
     */
    public int addGoodsCollection(HttpServletRequest request,AddGoodsCollectionReq req) {
        String token = request.getHeader("token");
        if (null == token){
            return 0;
        }
        Long customerId = JWT.decode(token).getClaim("id").asLong();
        if(null == customerId){
            return 0;
        }
        req.setCustomerId(customerId);
        //查询是否已经存在此用户收藏了该商品
        int collectionCount = this.selectCountBycustomerIdAndGoodsId(req.getCustomerId(),req.getGoodsId());
        if(collectionCount > 0){
            throw new RuntimeException("此用户已收藏了该商品");
        }

        //查询商品信息
        Goods goods = goodsService.selectGoodsInfo(req.getGoodsId());
        if(null == goods){
            throw new RuntimeException("没有此商品信息");
        }

        //收藏商品信息
        GoodsCollection collection = new GoodsCollection();
        collection.setCustomerId(req.getCustomerId());
        collection.setGoodsId(goods.getId());
        collection.setGoodsImg(goods.getGoodsImg());
        collection.setGoodsName(goods.getGoodsName());
        collection.setGoodsPrice(goods.getGoodsPrice());
        collection.setGoodsSpec(goods.getGoodsSpec());
        collection.setCreateTime(new Date());

        int count = goodsCollectionMapper.insertSelective(collection);
        return count;
    }


    public int selectCountBycustomerIdAndGoodsId(Long customerId, Long goodsId) {
        int count = goodsCollectionExtMapper.selectCountBycustomerIdAndGoodsId(customerId,goodsId);
        return count;
    }

    /**
     * lzn 2019/3/13 8:53
     * 商品收藏列表
     */
    public List<GoodsCollectionListRsp> goodsCollectionList(HttpServletRequest request, GoodsCollectionListReq req) {
        String token = request.getHeader("token");
        if(null == token){
            return null;
        }
        Long customerId = JWT.decode(token).getClaim("id").asLong();
        if(null == customerId){
            return null;
        }
        req.setCustomerId(customerId);

        List<GoodsCollection> goodsCollectionList = goodsCollectionExtMapper.selectGoodsCollectionListBycustomerId(req.getCustomerId());
        if(null == goodsCollectionList || goodsCollectionList.size() == 0 ){
            return null;
        }
        List<GoodsCollectionListRsp> goodsCollectionListRspList = new ArrayList<>();
        for(GoodsCollection goodsCollection : goodsCollectionList){
            GoodsCollectionListRsp rsp = new GoodsCollectionListRsp();
            goodsCollectionListRspList.add(rsp);

            rsp.setGoodsid(goodsCollection.getGoodsId());
            rsp.setGoodsImg(goodsCollection.getGoodsImg());
            rsp.setGoodsName(goodsCollection.getGoodsName());
            rsp.setGoodsPrice(goodsCollection.getGoodsPrice());
            rsp.setGoodsSpec(goodsCollection.getGoodsSpec());
        }
        return goodsCollectionListRspList;
    }

    /**
     * lzn 2019/3/19 8:45
     * 根据登陆会员和商品id查询此商品是否被收藏
     */
    public boolean isCollectionGoods(HttpServletRequest request, CollectionGoodsReq req) {
        String token = request.getHeader("token");
        if (null == token || token.equals("") || token.equals("null")){
            return false;
        }
        try {
            Long customerId = JWT.decode(token).getClaim("id").asLong();
            if (null == customerId) {
                return false;
            }
            int cuont = this.selectCountBycustomerIdAndGoodsId(customerId,req.getGoodsId());
            if(cuont > 0){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
