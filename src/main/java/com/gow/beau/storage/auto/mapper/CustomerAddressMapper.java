package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.CustomerAddress;
import com.gow.beau.storage.auto.model.CustomerAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerAddressMapper {
    long countByExample(CustomerAddressExample example);

    int deleteByExample(CustomerAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerAddress record);

    int insertSelective(CustomerAddress record);

    List<CustomerAddress> selectByExample(CustomerAddressExample example);

    CustomerAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerAddress record, @Param("example") CustomerAddressExample example);

    int updateByExample(@Param("record") CustomerAddress record, @Param("example") CustomerAddressExample example);

    int updateByPrimaryKeySelective(CustomerAddress record);

    int updateByPrimaryKey(CustomerAddress record);
}