package com.gow.beau.service.shoppingcart;

import com.auth0.jwt.JWT;
import com.gow.beau.api.login.LoginCustomer;
import com.gow.beau.model.req.shoppingcart.AddShoppingCartReq;
import com.gow.beau.model.req.shoppingcart.EditShoppingCartGoodsNumberReq;
import com.gow.beau.model.req.shoppingcart.ShoppingCartReq;
import com.gow.beau.model.rsp.shoppingcart.ShoppingCartGoodsListRsp;
import com.gow.beau.model.rsp.shoppingcart.ShoppingCartRsp;
import com.gow.beau.storage.auto.mapper.GoodsMapper;
import com.gow.beau.storage.auto.mapper.ShoppingCartMapper;
import com.gow.beau.storage.auto.model.Goods;
import com.gow.beau.storage.auto.model.ShoppingCart;
import com.gow.beau.storage.ext.mapper.ShoppingCartExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date: 2019/2/18 10:32<br/>
 *
 * @author lzn
 */
@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartExtMapper shoppingCartExtMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    public ShoppingCart getShoppingCart(Long shoppingCartId){
        return shoppingCartMapper.selectByPrimaryKey(shoppingCartId);
    }

    public int updateShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
    }

    public ShoppingCartRsp shoppingCartInfo(HttpServletRequest request, ShoppingCartReq req) {
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return null;
        }
        req.setCustomerId(customerId);

        ShoppingCartRsp rsp = new ShoppingCartRsp();
        //购物车总金额
        BigDecimal shopCartSumPrice = new BigDecimal(0);
        List<ShoppingCartGoodsListRsp> goodsList = new ArrayList<>();

        List<ShoppingCart> shoppingCartList = shoppingCartExtMapper.selectShoppingCartListByCustomerId(req.getCustomerId());
        if(!CollectionUtils.isEmpty(shoppingCartList)) {
            for (ShoppingCart shoppingCart : shoppingCartList) {
                ShoppingCartGoodsListRsp goodsRsp = new ShoppingCartGoodsListRsp();
                goodsRsp.setShoppingCartId(shoppingCart.getId());

                goodsList.add(goodsRsp);
                rsp.setShoppingCartGoodsListRsp(goodsList);
                //购物车数量
                goodsRsp.setGoodsNumber(shoppingCart.getGoodsNumber()==null?0:shoppingCart.getGoodsNumber());
                //查询商品信息，并计算总金额
                Goods goods = goodsMapper.selectByPrimaryKey(shoppingCart.getGoodsId());
                if(null != goods) {
                    goodsRsp.setGoodsId(goods.getId());
                    goodsRsp.setGoodsDeno(goods.getGoodsDeno());
                    goodsRsp.setGoodsImage(goods.getGoodsImg());
                    goodsRsp.setGoodsName(goods.getGoodsName());
                    goodsRsp.setGoodsNo(goods.getGoodsNo());
                    goodsRsp.setGoodsPrice(goods.getGoodsPrice()==null?new BigDecimal(0):goods.getGoodsPrice());
                    goodsRsp.setGoodsOldPrice(goods.getGoodsOldPrice()==null?new BigDecimal(0):goods.getGoodsOldPrice());
                    goodsRsp.setGoodsSpec(goods.getGoodsSpec());

                    //计算购物车总金额
                    BigDecimal goodsPrice = goodsRsp.getGoodsPrice().multiply(new BigDecimal(goodsRsp.getGoodsNumber()));
                    shopCartSumPrice = shopCartSumPrice.add(goodsPrice);
                }
            }
        }
        rsp.setShopCartSumPrice(shopCartSumPrice);

        return rsp;
    }

    /**
     *  2019/3/5 12:26
     * 加入购物车
     */
    public int addShoppingCart(HttpServletRequest request,AddShoppingCartReq req) {
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return 0;
        }
        req.setCustomerId(customerId);

        //商品
        Goods goods = goodsMapper.selectByPrimaryKey(req.getGoodsId());
        if(null == goods){
            throw new RuntimeException("没有此商品信息");
        }

        //修改购物车信息
        //根据customerId和goodsId 查询购物车信息，如果存在此会员的购物车信息,则修改购物车数量
        ShoppingCart shoppingCart = shoppingCartExtMapper.selectShoppingCartByCustomerIdAndGoodsId(req.getCustomerId(),req.getGoodsId());
        if(null != shoppingCart){
            shoppingCart.setGoodsNumber(shoppingCart.getGoodsNumber()+req.getNumber());
            int count = shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
            return count;
        }

        //增加一条购物车信息
        shoppingCart = new ShoppingCart();
        shoppingCart.setCustomerId(req.getCustomerId());
        shoppingCart.setGoodsId(goods.getId());
        shoppingCart.setGoodsPrice(goods.getGoodsPrice());
        shoppingCart.setGoodsNumber(req.getNumber());
        shoppingCart.setDelFlag("0");
        shoppingCart.setShoppingCartTime(new Date());
        int count = shoppingCartMapper.insertSelective(shoppingCart);
        return count;
    }

    /**
     * lzn 2019/3/11 18:41
     * 修改购物车数量
     */
    public int editShoppingCartGoodsNumber(HttpServletRequest request,EditShoppingCartGoodsNumberReq req) {
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return 0;
        }

        //如果数量为空或数量小于等于0，则不修改
        if(null == req.getGoodsNumber() || req.getGoodsNumber() <= 0){
            return 0;
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(req.getShoppingCartId());
        shoppingCart.setGoodsNumber(req.getGoodsNumber());
        int count = shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
        return count;
    }
}
