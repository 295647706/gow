package com.gow.beau.api.html;

import com.gow.beau.api.customer.CustomerAddressController;
import com.gow.beau.model.req.address.AddressReq;
import com.gow.beau.model.req.customer.CustomerReq;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2019/2/18 13:56<br/>
 *
 * @author lzn
 */
@Api(tags = "页面 - 地址")
@Controller
@RequestMapping("/addressPage")
public class AddressPageController {

    @Autowired
    private CustomerAddressController customerAddressController;

    /**
     * @Author:lzn
     * @Date:2019/2/18 14:01
     * 显示地址列表页面
     */
    @RequestMapping("/address-list-page")
    public ModelAndView addressListPage(HttpServletRequest request,CustomerReq req){
        ModelAndView view = new ModelAndView("address/address-list");
        view.addObject("addressList",customerAddressController.customerAddressList(request,req));
        return view;
    }

    /**
     * @Author:lzn
     * @Date:2019/2/18 14:01
     * 显示地址列表页面
     */
    @RequestMapping("/address2-list-page")
    public ModelAndView addressListPage2(HttpServletRequest request,CustomerReq req){
        ModelAndView view = new ModelAndView("address/new/address-list2");
        view.addObject("addressList",customerAddressController.customerAddressList(request,req));
        return view;
    }

    /**
     * @Author:lzn
     * @Date:2019/2/18 14:01
     * 添加地址页面
     */
    @RequestMapping("/address-add-page")
    public ModelAndView addressAddPage(){
        ModelAndView view = new ModelAndView("address/new/address-add2");
        return view;
    }

    /**
     * @Author:lzn
     * @Date:2019/2/18 14:02
     * 修改地址页面
     */
    @RequestMapping("/address-edid-page")
    public ModelAndView addressEditPage(AddressReq req){
        ModelAndView view = new ModelAndView("address/address-edit");
        view.addObject("addressInfo",customerAddressController.customerAddressInfo(req));
        return view;
    }

    /**
     * @Author:lzn
     * @Date:2019/2/18 14:02
     * 修改地址页面
     */
    @RequestMapping("/address2-edid-page")
    public ModelAndView addressEditPage2(AddressReq req){
        ModelAndView view = new ModelAndView("address/new/address-edit2");
        view.addObject("addressInfo",customerAddressController.customerAddressInfo(req));
        return view;
    }
}
