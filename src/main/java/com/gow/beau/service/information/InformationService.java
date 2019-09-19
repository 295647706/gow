package com.gow.beau.service.information;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.information.InformationListPageReq;
import com.gow.beau.model.rsp.information.InformationListPageRsp;
import com.gow.beau.model.rsp.information.InformationRsp;
import com.gow.beau.storage.auto.mapper.InformationMapper;
import com.gow.beau.storage.auto.model.Information;
import com.gow.beau.storage.ext.mapper.InformationExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName InformationService
 * @Author lzn
 * @DATE 2019/9/16 16:18
 */
@Service
public class InformationService {

    @Autowired
    private InformationExtMapper informationExtMapper;

    @Autowired
    private InformationMapper informationMapper;

    /**
     * 首页资讯列表
     * */
    public List<Information> pageInformationList(){
        List<Information> informationList = informationExtMapper.pageInformationList();
        return informationList;
    }


    /**
     * 资讯管理 - 列表数据
     * */
    public PageInfo informationListPage(InformationListPageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        List<Information> informationList = informationExtMapper.informationListPage(req);
        if(!CollectionUtils.isEmpty(informationList)){
            List<InformationListPageRsp> rspList = new ArrayList<>();
            for(Information information : informationList){
                InformationListPageRsp rsp = new InformationListPageRsp();
                BeanUtil.copyProperties(information,rsp);
                rsp.setCreateTimeF(DateUtil.dateToString2(information.getCreateTime()));
                rspList.add(rsp);
            }
            pageInfo.setList(rspList);
            pageInfo.setRows(this.informationListPageCount(req));
        }

        return pageInfo;
    }


    /**
     * 资讯管理 - 列表数据总数量
     * */
    private int informationListPageCount(InformationListPageReq req){
        return informationExtMapper.informationListPageCount(req);
    }


    /**
     * 新增
     * */
    public int add(Information information){
        //根据标题查询
        Integer count = informationExtMapper.selectCountTitle(information.getTitle(),null);
        if(count > 0){
            return -1;
        }
        Date date = new Date();
        information.setCreateTime(date);
        information.setModifyTime(date);
        information.setIsDelete("0");
        information.setEvaluateNumber(0);
        information.setToViewNumber(0);
        information.setPraiseNumber(0);
        return informationMapper.insertSelective(information);
    }


    /**
     * 删除
     * */
    public int del(Long id){
        Information information = informationMapper.selectByPrimaryKey(id);
        if(null == information){
            return 0;
        }
        if(information.getIsSubmit().equals("1")){
            return -1;
        }
        information.setIsDelete("1");
        information.setDeleteTime(new Date());
        return informationMapper.updateByPrimaryKeySelective(information);
    }


    /**
     * 根据id查询信息详情
     * */
    public InformationRsp getInfo(Long id){
        InformationRsp rsp = new InformationRsp();
        Information information = informationMapper.selectByPrimaryKey(id);
        if(null != information){
            BeanUtil.copyProperties(information,rsp);
            rsp.setCreateTimeF(DateUtil.dateToString2(information.getCreateTime()));
            rsp.setModifyTimeF(DateUtil.dateToString2(information.getModifyTime()));
            if(information.getToViewNumber() > 0){
                String toViewNumberF = "阅读";
                if(information.getToViewNumber() > 10000){
                    BigDecimal bg = new BigDecimal((double)information.getToViewNumber()/10000);
                    double d = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    d = d + 0.1;
                    String number = "";
                    String[] numbers =  String.valueOf(d).split("\\.");
                    if(numbers[1].equals("0")){
                        number = numbers[0];
                    }else{
                        number = d+"";
                    }
                    toViewNumberF = number + "万" + toViewNumberF;
                }else{
                    toViewNumberF = information.getToViewNumber() + toViewNumberF;
                }
                rsp.setToViewNumberF(toViewNumberF);
            }
        }
        return rsp;
    }


    /**
     * 编辑
     * */
    public int edit(Information information){
        //根据标题查询
        Integer count = informationExtMapper.selectCountTitle(information.getTitle(),information.getId());
        if(count > 0){
            return -1;
        }
        Information query = informationMapper.selectByPrimaryKey(information.getId());
        if(null == query){
            return 0;
        }
        if(query.getIsSubmit().equals("1")){
            return -2;
        }
        information.setModifyTime(new Date());
        return informationMapper.updateByPrimaryKeySelective(information);
    }


    /**
     * 草稿 或 发布
     * */
    public int infoIssue(Long id){
        Information query = informationMapper.selectByPrimaryKey(id);
        if(null == query){
            return 0;
        }
        if(query.getIsSubmit().equals("0")){
            query.setIsSubmit("1");
        }else if(query.getIsSubmit().equals("1")){
            query.setIsSubmit("0");
        }
        query.setModifyTime(new Date());
        return informationMapper.updateByPrimaryKeySelective(query);
    }


    /**
     * 修改阅读量
     * */
    public int updateToViewNumberById(Long id){
        Information query = informationMapper.selectByPrimaryKey(id);
        if(null == query){
            return 0;
        }
        Information editInformation = new Information();
        editInformation.setId(id);
        editInformation.setToViewNumber(query.getToViewNumber()==null?1:query.getToViewNumber()+1);
        editInformation.setModifyTime(new Date());
        return informationMapper.updateByPrimaryKeySelective(editInformation);
    }
}
