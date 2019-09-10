package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.Paytype;
import com.gow.beau.storage.auto.model.PaytypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaytypeMapper {
    long countByExample(PaytypeExample example);

    int deleteByExample(PaytypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Paytype record);

    int insertSelective(Paytype record);

    List<Paytype> selectByExample(PaytypeExample example);

    Paytype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Paytype record, @Param("example") PaytypeExample example);

    int updateByExample(@Param("record") Paytype record, @Param("example") PaytypeExample example);

    int updateByPrimaryKeySelective(Paytype record);

    int updateByPrimaryKey(Paytype record);
}