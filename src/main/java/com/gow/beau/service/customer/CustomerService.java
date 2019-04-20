package com.gow.beau.service.customer;

import com.auth0.jwt.JWT;
import com.gow.beau.model.req.customer.CustomerReq;
import com.gow.beau.model.req.customer.EditCustomerInfoReq;
import com.gow.beau.model.req.regist.RegistUsernameReq;
import com.gow.beau.model.rsp.customer.CustomerInfoRsp;
import com.gow.beau.model.rsp.customer.CustomerRsp;
import com.gow.beau.model.rsp.login.LoginRsp;
import com.gow.beau.storage.auto.mapper.CustomerMapper;
import com.gow.beau.storage.auto.model.Customer;
import com.gow.beau.storage.ext.mapper.CustomerExtMapper;
import com.gow.beau.util.SettingValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2019/2/18 14:15<br/>
 *
 * @author lzn
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerExtMapper customerExtMapper;

    public CustomerRsp selectCustomerInfoByCustomerId(CustomerReq req) {
        Customer customer = customerMapper.selectByPrimaryKey(req.getCustomerId());
        CustomerRsp rsp = new CustomerRsp();
        if(null == customer){
            return rsp;
        }
        SettingValueUtil.settingObject2(customer,rsp);
        rsp.setCustomerId(customer.getId());
        return rsp;
    }

    public int editCustomerInfo(EditCustomerInfoReq req) {
        Customer customer = new Customer();
        customer.setId(req.getCustomerId());
        customer.setAddress(req.getAddress().trim().equals("")?null:req.getAddress());
        customer.setCustomerRealname(req.getCustomerRealname().trim().equals("")?null:req.getCustomerRealname());
        customer.setSex(req.getSex().trim().equals("")?null:req.getSex());
        int count = customerMapper.updateByPrimaryKeySelective(customer);
        return count;
    }

    public LoginRsp selectCustomerNameAndPaddByName(String name) {
        LoginRsp rsp = customerExtMapper.selectCustomerNameAndPaddByName(name);
        return rsp;
    }

    public Customer selectCustomerInfoByCustomerId(Long customerId){
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }

    /**
     * lzn 2019/3/18 15:09
     * 查询会员的信息
     */
    public CustomerInfoRsp selectCustomerInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        if(null == token){
            return null;
        }
        Long customerId = JWT.decode(token).getClaim("id").asLong();
        if(null==customerId){
            return null;
        }

        Customer customer = this.selectCustomerInfoByCustomerId(customerId);
        if(null == customer){
            return null;
        }

        CustomerInfoRsp rsp = new CustomerInfoRsp();
        rsp.setCustomerId(customer.getId());
        rsp.setCustomerImg(customer.getCustomerImg());
        if(null == customer.getCustomerNickname()){
            rsp.setCustomerNickname(customer.getCustomerUsername());
        }else{
            rsp.setCustomerNickname(customer.getCustomerNickname());
        }
        rsp.setCustomerRealname(customer.getCustomerRealname());
        rsp.setCustomerUsername(customer.getCustomerUsername());

        return rsp;
    }

    /**
     * lzn 2019/3/19 14:48
     * 创建用户
     */
    public int addCustomer(Customer customer) {
        //根据用户名查询是存在一样的用户
        int count = customerExtMapper.selectCountByName(customer.getCustomerUsername());
        if(count > 0){
            //已经存在用户，不允许登陆
            return 0;
        }
        return customerMapper.insertSelective(customer);
    }

    /**
     * lzn 2019/3/19 15:07
     * 根据用户名检查用户是否存在
     */
    public boolean isExistCustomerUsername(RegistUsernameReq req) {
        //根据用户名查询是存在一样的用户
        int count = customerExtMapper.selectCountByName(req.getUsername());
        if(count==0){
            return true;
        }
        return false;
    }
}
