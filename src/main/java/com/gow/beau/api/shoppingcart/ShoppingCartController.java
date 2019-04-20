package com.gow.beau.api.shoppingcart;

import com.gow.beau.model.req.shoppingcart.AddShoppingCartReq;
import com.gow.beau.model.req.shoppingcart.EditShoppingCartGoodsNumberReq;
import com.gow.beau.model.req.shoppingcart.ShoppingCartReq;
import com.gow.beau.model.rsp.shoppingcart.ShoppingCartRsp;
import com.gow.beau.service.shoppingcart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2019/2/18 10:23<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/shoppingCartInfo")
    @ResponseBody
    public ShoppingCartRsp shoppingCartInfo(HttpServletRequest request,ShoppingCartReq req){
        return shoppingCartService.shoppingCartInfo(request,req);
    }

    /**
     *  2019/3/5 12:26
     * 加入购物车
     */
    @RequestMapping("/addShoppingCart")
    @ResponseBody
    public int addShoppingCart(HttpServletRequest request,AddShoppingCartReq req){
        return shoppingCartService.addShoppingCart(request,req);
    }

    /**
     * lzn 2019/3/11 18:41
     * 修改购物车数量
     */
    @RequestMapping("/editShoppingCartGoodsNumber")
    @ResponseBody
    public int editShoppingCartGoodsNumber(HttpServletRequest request,EditShoppingCartGoodsNumberReq req){
        return shoppingCartService.editShoppingCartGoodsNumber(request,req);
    }
}
