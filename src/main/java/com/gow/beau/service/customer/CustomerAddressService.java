package com.gow.beau.service.customer;

import com.gow.beau.model.req.address.AddEditCustomerAddressReq;
import com.gow.beau.model.req.address.AddressReq;
import com.gow.beau.model.req.address.DeleteAddressReq;
import com.gow.beau.model.req.customer.CustomerReq;
import com.gow.beau.model.rsp.address.AddressRsp;
import com.gow.beau.model.rsp.customer.CustomerAddressListRsp;
import com.gow.beau.model.rsp.order.OrderConfirmAddressRsp;
import com.gow.beau.storage.auto.mapper.CustomerAddressMapper;
import com.gow.beau.storage.auto.model.CustomerAddress;
import com.gow.beau.storage.ext.mapper.CustomerAddressExtMapper;
import com.gow.beau.util.SettingValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Date: 2019/2/18 15:44<br/>
 *
 * @author lzn
 */
@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressExtMapper customerAddressExtMapper;

    @Autowired
    private CustomerAddressMapper customerAddressMapper;

    public List<CustomerAddressListRsp> customerAddressList(CustomerReq req) {
        List<CustomerAddressListRsp> customerAddressListRspList = customerAddressExtMapper.customerAddressList(req.getCustomerId());
        return customerAddressListRspList;
    }

    public AddressRsp customerAddressInfo(AddressReq req) {
        CustomerAddress address = customerAddressMapper.selectByPrimaryKey(req.getAddressId());
        AddressRsp rsp = new AddressRsp();
        SettingValueUtil.settingObject2(address,rsp);
        return rsp;
    }

    public int editCustomerAddress(AddEditCustomerAddressReq req) {
        CustomerAddress address = new CustomerAddress();
        //如果设置了默认地址，则把之前的改成非默认的
        if(req.getIsDefault().trim().equals("1")){
            address.setIsDefault(req.getIsDefault());
            customerAddressExtMapper.editCustomerAddressIsDefault(req.getCustomerId());
        }
        address.setId(req.getAddressId());
        if(null != req.getAddress()){
            String[] adds = req.getAddress().split(" ");
            req.setAddressProvince(adds[0]);
            req.setAddressCity(adds[1]);
            req.setAddressCounty(adds[2]);
        }
        SettingValueUtil.settingObject2(req,address);
        int count = customerAddressMapper.updateByPrimaryKeySelective(address);
        return count;
    }

    public int addCustomerAddress(AddEditCustomerAddressReq req) {
        if(null != req.getAddress()){
            String[] adds = req.getAddress().split(" ");
            req.setAddressProvince(adds[0]);
            req.setAddressCity(adds[1]);
            req.setAddressCounty(adds[2]);
        }
        CustomerAddress address = new CustomerAddress();
        SettingValueUtil.settingObject2(req,address);
        address.setId(null);
        /*address.setCustomerId(req.getCustomerId());
        address.setAddressName(req.getAddressName());
        address.setAddressDetail(req.getAddressDetail());
        address.setAddressPhone(req.getAddressPhone());
        address.setAddressPhone(req.getAddressPhone());
        address.setAddressProvince(req.getAddressProvince());
        address.setAddressCity(req.getAddressCity());
        address.setAddressCounty(req.getAddressCounty());
        address.setAddressStreet(req.getAddressStreet());
        address.setAddressTelephone(req.getAddressTelephone());
        address.setAddressEmail(req.getAddressEmail());*/
        address.setCreateTime(new Date());
        int count = customerAddressMapper.insertSelective(address);
        return count;
    }

    /**
     * lzn 2019/3/6 18:05
     * 根据会员id 查询默认地址
     */
    public OrderConfirmAddressRsp selectIsDefaultAddressByCustomerId(Long customerId) {
        return customerAddressExtMapper.selectIsDefaultAddressByCustomerId(customerId);
    }

    /**
     * lzn 2019/3/6 21:44
     * 根据会员id 查询最新添加的地址
     */
    public OrderConfirmAddressRsp selectLatestAddressByCustomerId(Long customerId) {
        return customerAddressExtMapper.selectLatestAddressByCustomerId(customerId);
    }

    public CustomerAddress getCustomerAddress(Long addressId){
        return customerAddressMapper.selectByPrimaryKey(addressId);
    }

    /**
     * lzn 2019/3/13 9:35
     * 删除地址
     */
    public int deleteAddressById(DeleteAddressReq req) {
        CustomerAddress address = new CustomerAddress();
        address.setId(req.getAddressId());
        address.setIsDelete("1");
        int count = customerAddressMapper.updateByPrimaryKeySelective(address);
        return count;
    }
}
