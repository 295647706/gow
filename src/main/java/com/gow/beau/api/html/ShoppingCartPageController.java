package com.gow.beau.api.html;

import com.gow.beau.api.shoppingcart.ShoppingCartController;
import com.gow.beau.model.req.shoppingcart.ShoppingCartReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2019/2/18 10:09<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/shoppingCartPage")
public class ShoppingCartPageController {

    @Autowired
    private ShoppingCartController shoppingCartController;

    @RequestMapping("/shopping-cart-page")
    public ModelAndView shoppingCartPage(HttpServletRequest request, ShoppingCartReq req){
        ModelAndView view = new ModelAndView("shopping-cart/shopping-cart");
        view.addObject("shoppingCartInfo",shoppingCartController.shoppingCartInfo(request,req));
        return view;
    }
}
