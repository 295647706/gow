package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.rsp.customer.CustomerAddressListRsp;
import com.gow.beau.model.rsp.order.OrderConfirmAddressRsp;
import com.gow.beau.storage.auto.model.CustomerAddress;
import com.gow.beau.storage.auto.model.CustomerAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerAddressExtMapper {

    List<CustomerAddressListRsp> customerAddressList(@Param("customerId") Long customerId);

    int editCustomerAddressIsDefault(@Param("customerId") Long customerId);

    /**
     * lzn 2019/3/6 18:05
     * 根据会员id 查询默认地址
     */
    OrderConfirmAddressRsp selectIsDefaultAddressByCustomerId(@Param("customerId") Long customerId);

    /**
     * lzn 2019/3/6 21:44
     * 根据会员id 查询最新添加的地址
     */
    OrderConfirmAddressRsp selectLatestAddressByCustomerId(@Param("customerId") Long customerId);
}