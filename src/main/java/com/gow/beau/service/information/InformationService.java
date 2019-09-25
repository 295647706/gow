package com.gow.beau.service.information;

import com.gow.beau.api.login.LoginCustomer;
import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.information.InformationListPageReq;
import com.gow.beau.model.rsp.information.InformationListPageRsp;
import com.gow.beau.model.rsp.information.InformationRsp;
import com.gow.beau.service.informationoperation.InformationOperationService;
import com.gow.beau.storage.auto.mapper.InformationMapper;
import com.gow.beau.storage.auto.model.Information;
import com.gow.beau.storage.auto.model.InformationOperation;
import com.gow.beau.storage.ext.mapper.InformationExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private InformationOperationService informationOperationService;

    /**
     * 首页资讯列表
     * */
    public List<Information> pageInformationList(){
        List<Information> informationList = informationExtMapper.pageInformationList();
        if(CollectionUtils.isEmpty(informationList)){
            informationList = new ArrayList<>();
            Information information = new Information();
            informationList.add(information);
            return informationList;
        }
        return informationList;
    }


    /**
     * 资讯列表-分页
     * */
    public PageInfo selectInfoformationPage(HttpServletRequest request,InformationListPageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        List<Information> informationList = informationExtMapper.informationListPage(req);
        if(!CollectionUtils.isEmpty(informationList)){
            Long customerId = LoginCustomer.getCustomerIdByToken(request);
            List<InformationRsp> rspList = new ArrayList<>();
            for(Information information : informationList){
                InformationRsp rsp = getInformationRsp(information,customerId);
                rspList.add(rsp);
            }
            pageInfo.setList(rspList);
            pageInfo.setRows(this.informationListPageCount(req));
        }
        return pageInfo;
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
                rsp.setCreateTimeF(DateUtil.dateToString(information.getCreateTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));
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
        Information information = informationMapper.selectByPrimaryKey(id);
        return this.getInformationRsp(information,null);
    }

    /**
     * 处理详情字段
     * */
    private InformationRsp getInformationRsp(Information information,Long customerId){
        InformationRsp rsp = new InformationRsp();
        if(null != information){
            BeanUtil.copyProperties(information,rsp);
            rsp.setCreateTimeF(DateUtil.dateToString(information.getCreateTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));
            rsp.setModifyTimeF(DateUtil.dateToString(information.getModifyTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));
            String[] forms = {"阅读","评价"};
            //阅读量
            String toViewNumber = this.getDoShuzi(information.getToViewNumber());
            if(null != toViewNumber) {
                toViewNumber = toViewNumber + forms[0];
                rsp.setToViewNumberF(toViewNumber);
            }
            //评价数量
            String evaluateNumber = this.getDoShuzi(information.getEvaluateNumber());
            if(null != evaluateNumber) {
                evaluateNumber = evaluateNumber + forms[1];
                rsp.setEvaluateNumberF(evaluateNumber);
            }
            //是否已关注，0：未关注，1：已关注
            if(null != customerId){
                InformationOperation operation = informationOperationService.getInformationOperation(customerId,information.getId());
                if(null != operation){
                    if(operation.getIsFocus().equals("1")){
                        rsp.setIsFocus(1);
                    }
                }
            }
        }
        return rsp;
    }

    /**
     * 数字数量处理
     * */
    private String getDoShuzi(int number){
        String donumber = null;
        if(number > 0){
            if(number > 10000){
                String wan = "万";
                BigDecimal bg = new BigDecimal((double)number/10000);
                double d = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                d = d + 0.1;
                String[] numbers =  String.valueOf(d).split("\\.");
                if(numbers[1].equals("0")){
                    donumber = numbers[0] + wan;
                }else{
                    donumber = d + wan;
                }
            }else{
                donumber = number+"";
            }
        }
        return donumber;
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


    /**
     * 点赞
     * */
    public int toPraiseNumber(HttpServletRequest request,Long id){
        Information query = informationMapper.selectByPrimaryKey(id);
        if(null == query){
            return 0;
        }
        //点赞数量
        Integer praiseNumber = (query.getPraiseNumber()==null?1:query.getPraiseNumber()+1);

        //新的保存对象
        Information information = new InformationRsp();
        information.setId(id);
        information.setPraiseNumber(praiseNumber);
        information.setModifyTime(new Date());
        int count = informationMapper.updateByPrimaryKeySelective(information);
        if(count > 0){
            //如果登陆用户不为空，则保存或修改点赞信息
            Long customerId = LoginCustomer.getCustomerIdByToken(request);
            if(null != customerId){
                informationOperationService.saveOrEdit(customerId,id,2);
            }
            //返回点赞数量
            return praiseNumber;
        }
        return 0;
    }


    /**
     * 关注
     * */
    public int toFocusOn(HttpServletRequest request, Long id){
        //取登陆用户id,如果未登陆则返回null
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return -1;
        }
        //保存 或 修改 资讯操作信息,1：关注，2：点赞
        int count = informationOperationService.saveOrEdit(customerId,id,1);
        return count;
    }

    /**
     * 是否已关注
     * */
    public int toFoucsBtn(HttpServletRequest request, Long id){
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        InformationOperation operation = informationOperationService.getInformationOperation(customerId,id);
        if(null != operation){
            if(operation.getIsFocus().equals("1")){
                return 1;
            }
        }
        return 0;
    }
}
