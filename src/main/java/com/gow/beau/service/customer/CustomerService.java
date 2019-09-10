package com.gow.beau.service.customer;

import com.auth0.jwt.JWT;
import com.gow.beau.api.login.LoginCustomer;
import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.customer.*;
import com.gow.beau.model.req.regist.RegistUsernameReq;
import com.gow.beau.model.rsp.customer.CustomerInfoRsp;
import com.gow.beau.model.rsp.customer.CustomerListPageRsp;
import com.gow.beau.model.rsp.customer.CustomerRsp;
import com.gow.beau.model.rsp.login.LoginRsp;
import com.gow.beau.storage.auto.mapper.CustomerMapper;
import com.gow.beau.storage.auto.model.Customer;
import com.gow.beau.storage.ext.mapper.CustomerExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import com.gow.beau.util.SettingValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
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

        Date date = new Date();
        customer.setCreateTime(date);
        customer.setModifyTime(date);
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


    public String editPass(HttpServletRequest request, CustomerEditPassReq req){
        String token = request.getHeader("token");
        if(!req.getNewpass1().equals(req.getNewpass2())){
            return "两次输入的密码不一致";
        }
        if(req.getNewpass1().length() < 6 || req.getNewpass1().length() > 18){
            return "密码设置必须在6 ~ 18 位之间";
        }
        if(token.equals(null) || token.equals("") || token.equals("null")){
            return "0";
        }
        Long customerId = JWT.decode(token).getClaim("id").asLong();
        if(null==customerId){
            return "0";
        }
        Customer customer = this.selectCustomerInfoByCustomerId(customerId);
        if(null == customer){
            return "0";
        }
        if(!req.getOldpass().equals(customer.getCustomerPassword())){
            return "原始密码错误";
        }

        //修改密码
        Customer editCustomer = new Customer();
        editCustomer.setId(customerId);
        editCustomer.setCustomerPassword(req.getNewpass1());
        editCustomer.setModifyTime(new Date());
        customerMapper.updateByPrimaryKeySelective(editCustomer);

        return "密码修改成功";
    }

    /**
     * 会员管理 - 会员列表数据
     * */
    public PageInfo getCustomerListPage(CustomerListPageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        //查询会员
        List<Customer> customerList = customerExtMapper.getCustomerListPage(req);
        if(!CollectionUtils.isEmpty(customerList)){
            List<CustomerListPageRsp> rspList = new ArrayList<>();
            for(Customer customer : customerList){
                CustomerListPageRsp rsp = new CustomerListPageRsp();
                BeanUtil.copyProperties(customer, rsp);

                rsp.setCustomerRealname(customer.getCustomerRealname()==null?"":customer.getCustomerRealname());
                rsp.setIsUse(customer.getIsUse().equals("0")?"正常":"已冻结");
                rsp.setSex(customer.getSex()==null?"":customer.getSex());
                rsp.setBirthdayF(DateUtil.dateToString(customer.getBirthday()));
                rsp.setCreateTimeF(DateUtil.dateToString2(customer.getCreateTime()));

                rspList.add(rsp);
            }
            pageInfo.setList(rspList);
            pageInfo.setRows(this.getCustomerCount(req));
        }
        return pageInfo;
    }

    /**
     * 会员管理 列表 会员总数
     * */
    private int getCustomerCount(CustomerListPageReq req){
        return customerExtMapper.getCustomerCount(req);
    }

    /**
     * 删除会员
     * */
    public int deleteCustomerManage(Long customerId){
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setIsDelete("1");
        customer.setModifyTime(new Date());
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 会员详情
     * */
    public CustomerListPageRsp detailCustomerManage(Long customerId){
        CustomerListPageRsp rsp = new CustomerListPageRsp();
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        if(null == customer){
            return rsp;
        }
        BeanUtil.copyProperties(customer, rsp);

        rsp.setCustomerRealname(customer.getCustomerRealname()==null?"":customer.getCustomerRealname());
        rsp.setSex(customer.getSex()==null?"":customer.getSex());
        rsp.setBirthdayF(DateUtil.dateToString(customer.getBirthday()));
        rsp.setCreateTimeF(DateUtil.dateToString2(customer.getCreateTime()));

        return rsp;
    }


    /**
     * 修改冻结状态
     * */
    public int updateCustomerIsUse(CustomerIsUerReq req){
        Customer customer = new Customer();
        customer.setId(req.getCustomerId());
        customer.setIsUse(req.getIsUse());
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

}
