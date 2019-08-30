package com.gow.beau.storage.ext.mapper;

import com.gow.beau.model.req.customer.CustomerListPageReq;
import com.gow.beau.model.rsp.login.LoginRsp;
import com.gow.beau.storage.auto.model.Customer;
import com.gow.beau.storage.auto.model.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerExtMapper {

    LoginRsp selectCustomerNameAndPaddByName(@Param("name") String name);

    /**
     * lzn 2019/3/19 15:05
     * 根据用户名查询是存在一样的用户
     */
    int selectCountByName(@Param("customerUsername") String customerUsername);

    List<Customer> getCustomerListPage(CustomerListPageReq req);

    int getCustomerCount(CustomerListPageReq req);
}