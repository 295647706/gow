package com.gow.beau.api.customer;

import com.auth0.jwt.JWT;
import com.gow.beau.api.login.LoginCustomer;
import com.gow.beau.model.req.address.AddEditCustomerAddressReq;
import com.gow.beau.model.req.address.AddressReq;
import com.gow.beau.model.req.address.DeleteAddressReq;
import com.gow.beau.model.req.customer.CustomerReq;
import com.gow.beau.model.rsp.address.AddressRsp;
import com.gow.beau.model.rsp.customer.CustomerAddressListRsp;
import com.gow.beau.service.customer.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Date: 2019/2/18 15:43<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/customerAddress")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @RequestMapping("/customerAddressList")
    @ResponseBody
    public List<CustomerAddressListRsp> customerAddressList(HttpServletRequest request,CustomerReq req){
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return null;
        }
        req.setCustomerId(customerId);

        return customerAddressService.customerAddressList(req);
    }

    @RequestMapping("/customerAddressInfo")
    public AddressRsp customerAddressInfo(AddressReq req) {
        return customerAddressService.customerAddressInfo(req);
    }

    @RequestMapping("/editCustomerAddress")
    public int editCustomerAddress(HttpServletRequest request,AddEditCustomerAddressReq req){
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return 0;
        }
        req.setCustomerId(customerId);
        return customerAddressService.editCustomerAddress(req);
    }

    @RequestMapping("/addCustomerAddress")
    @ResponseBody
    public int addCustomerAddress(HttpServletRequest request,AddEditCustomerAddressReq req){
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return 0;
        }
        req.setCustomerId(customerId);
        return customerAddressService.addCustomerAddress(req);
    }

    /**
     * lzn 2019/3/13 9:35
     * 删除地址
     */
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public int deleteAddressById(DeleteAddressReq req){
        return customerAddressService.deleteAddressById(req);
    }
}
