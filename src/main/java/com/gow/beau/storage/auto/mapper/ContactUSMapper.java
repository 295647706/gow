package com.gow.beau.storage.auto.mapper;

import com.gow.beau.storage.auto.model.ContactUS;
import com.gow.beau.storage.auto.model.ContactUSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactUSMapper {
    long countByExample(ContactUSExample example);

    int deleteByExample(ContactUSExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContactUS record);

    int insertSelective(ContactUS record);

    List<ContactUS> selectByExample(ContactUSExample example);

    ContactUS selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContactUS record, @Param("example") ContactUSExample example);

    int updateByExample(@Param("record") ContactUS record, @Param("example") ContactUSExample example);

    int updateByPrimaryKeySelective(ContactUS record);

    int updateByPrimaryKey(ContactUS record);
}