package com.gow.beau.storage.ext.mapper;

import com.gow.beau.storage.auto.model.InformationOperation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationOperationExtMapper {


    InformationOperation selectInfoByCustomerIdAndInformationId(@Param("customerId") Long customerId,@Param("informationId") Long informationId);
}