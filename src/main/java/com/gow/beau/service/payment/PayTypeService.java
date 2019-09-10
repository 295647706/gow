package com.gow.beau.service.payment;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.payment.PayTypeListReq;
import com.gow.beau.model.rsp.payment.PayTypeListRsp;
import com.gow.beau.storage.auto.mapper.PaytypeMapper;
import com.gow.beau.storage.auto.model.Paytype;
import com.gow.beau.storage.ext.mapper.PaytypeExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @ClassName PayTypeService
 * @Author lzn
 * @DATE 2019/9/9 14:03
 * 支付类型
 */
@Service
public class PayTypeService {

    @Autowired
    private PaytypeExtMapper paytypeExtMapper;

    @Autowired
    private PaytypeMapper paytypeMapper;


    /**
     * 支付页面显示
     * */
    public List<Paytype> getPaytypeAll(){
        List<Paytype> paytypeList = paytypeExtMapper.getPaytypeAll();
        if(CollectionUtils.isEmpty(paytypeList)){
            paytypeList = new ArrayList<>();
        }
        return paytypeList;
    }


    /**
     * 支付类型 - 列表数据
     * */
    public PageInfo getPayTypeListPage(PayTypeListReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        List<PayTypeListRsp> payTypeListRsps = new ArrayList<>();
        List<Paytype> paytypeList = paytypeExtMapper.getPayTypeListPage(req);
        if(!CollectionUtils.isEmpty(paytypeList)){
            for(Paytype paytype : paytypeList){
                PayTypeListRsp rsp = new PayTypeListRsp();
                BeanUtil.copyProperties(paytype,rsp);
                payTypeListRsps.add(rsp);
                if(rsp.getPayType().equals("alipay")){
                    rsp.setPayType("支付宝");
                }else if(rsp.getPayType().equals("wechat")){
                    rsp.setPayType("微信");
                }
                rsp.setCreateTimeF(DateUtil.dateToString2(paytype.getCreateTime()));
                rsp.setContent(rsp.getContent()==null?"":rsp.getContent());
            }
        }
        pageInfo.setList(payTypeListRsps);
        pageInfo.setRows(payTypeListRsps.size());
        return pageInfo;
    }

    /**
     * 一键生成支付设置
     * */
    public int setPayType(){
        int count = 0;
        //基础信息，需要生成的基础支付类型
        String[] infos = {"alipay","wechat"};
        //已存在的支付类型
        Map<String,String> map = new HashMap<>();

        //查询全部列表,包括删除的
        List<Paytype> paytypeList = paytypeExtMapper.selectPayTypeList();

        //把已经出现的，并且之前删除的修改为：未删除，并把已经出现的放到map中
        if(!CollectionUtils.isEmpty(paytypeList)){
            for(String type : infos){
                for(Paytype paytype : paytypeList){
                    //如果数据库已存在一条被删除的支付类型，设置的时候则把这条修改为：未删除状态
                    if(paytype.getPayType().equals(type)){
                        if(paytype.getIsDelete().equals("1")) {
                            paytype.setIsDelete("0");
                            count += paytypeMapper.updateByPrimaryKeySelective(paytype);
                        }
                        //把已经出现的放到map中
                        map.put(type,type);
                    }
                }
            }
        }

        //保存信息新的数据
        for(String type : infos){
            //如果在map中未找到，则需要新增
            if(!type.equals(map.get(type))) {
                Paytype paytype = new Paytype();
                paytype.setPayType(type);
                paytype.setIsDefault("0");
                paytype.setCreateTime(new Date());
                paytype.setIsDelete("0");
                paytype.setIsUse("0");
                paytype.setContent("");
                count += paytypeMapper.insertSelective(paytype);
            }
        }

        return count;
    }


    /**
     * 删除
     * */
    public int payTypeDelete(Long payTypeId){
        Paytype paytype = new Paytype();
        paytype.setId(payTypeId);
        paytype.setIsDelete("1");
        return paytypeMapper.updateByPrimaryKeySelective(paytype);
    }


    /**
     * 设置默认
     * */
    public int isDefault(Long payTypeId){
        Paytype paytype = paytypeMapper.selectByPrimaryKey(payTypeId);
        if(null == paytype){
            return 0;
        }
        if(paytype.getIsUse().equals("0")) {
            //把其他所有（包括已删除的）都设置为：非默认
            paytypeExtMapper.updateIsDefaultByAll();
            //把此id的设置为默认
            paytype.setIsDefault("1");
            return paytypeMapper.updateByPrimaryKeySelective(paytype);
        }else{
            return -1;
        }
    }

    /**
     * 设置启动、禁用
     * */
    public int isUse(Long payTypeId){
        Paytype paytype = paytypeMapper.selectByPrimaryKey(payTypeId);
        if(null == paytype){
            return 0;
        }
        paytype.setId(payTypeId);
        paytype.setIsUse(paytype.getIsUse().equals("0")?"1":"0");
        return paytypeMapper.updateByPrimaryKeySelective(paytype);
    }

    //详情
    public Paytype getPaytypeByid(Long payTypeId){
        Paytype paytype = paytypeMapper.selectByPrimaryKey(payTypeId);
        if(paytype.getPayType().equals("alipay")){
            paytype.setPayType("支付宝");
        }else if(paytype.getPayType().equals("wechat")){
            paytype.setPayType("微信");
        }
        return paytype;
    }


    /**
     * 修改内容
     * */
    public int updateContent(Paytype paytype){
        return paytypeMapper.updateByPrimaryKeySelective(paytype);
    }
}
