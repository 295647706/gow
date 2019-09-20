package com.gow.beau.service.informationoperation;

import com.gow.beau.storage.auto.mapper.InformationOperationMapper;
import com.gow.beau.storage.auto.model.InformationOperation;
import com.gow.beau.storage.ext.mapper.InformationOperationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName InformationOperationService
 * @Author lzn
 * @DATE 2019/9/20 16:57
 */@Service

public class InformationOperationService {

     @Autowired
     private InformationOperationExtMapper informationOperationExtMapper;

     @Autowired
     private InformationOperationMapper informationOperationMapper;

     /**
      * 根据登陆用户id 和 资讯id 查询信息
      * */
     public InformationOperation getInformationOperation(Long customerId,Long informationId){
         InformationOperation operation = informationOperationExtMapper.selectInfoByCustomerIdAndInformationId(customerId,informationId);
         return operation;
     }

     //保存 或 修改 资讯操作信息,1：关注，2：点赞
     public int saveOrEdit(Long customerId,Long informationId,int type){
         InformationOperation operation = this.getInformationOperation(customerId,informationId);
         Date date = new Date();
         if(null == operation){
             operation = new InformationOperation();
             operation.setCustomerId(customerId);
             operation.setInformationId(informationId);
             operation.setCreateTime(date);
             if(type==1){
                 operation.setFocusTime(date);
                 operation.setIsFocus("1");
                 operation.setIsPraise("0");
             }else if(type == 2){
                 operation.setPraiseTime(date);
                 operation.setIsPraise("1");
                 operation.setIsFocus("0");
             }
             return informationOperationMapper.insertSelective(operation);
         }else{
             //是否需要修改
             boolean isBe = false;
             InformationOperation edit = new InformationOperation();
             edit.setId(operation.getId());
             if(type==1){
                 if(operation.getIsFocus().equals("0")){
                     isBe = true;
                 }
                 edit.setFocusTime(date);
                 edit.setIsFocus("1");
             }else if(type == 2){
                 if(operation.getIsPraise().equals("0")){
                     isBe = true;
                 }
                 edit.setPraiseTime(date);
                 edit.setIsPraise("1");
             }
             if(isBe) {
                 return informationOperationMapper.updateByPrimaryKeySelective(edit);
             }
         }
         return 0;
     }


}
