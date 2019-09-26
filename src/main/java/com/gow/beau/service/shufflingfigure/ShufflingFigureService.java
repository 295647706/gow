package com.gow.beau.service.shufflingfigure;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureAddReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureEditReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigurePageReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureSetTimeReq;
import com.gow.beau.model.rsp.shufflingfigure.ShufflingFigureRsp;
import com.gow.beau.storage.auto.mapper.ShufflingFigureMapper;
import com.gow.beau.storage.auto.mapper.ShufflingFigureNumberMapper;
import com.gow.beau.storage.auto.model.ShufflingFigure;
import com.gow.beau.storage.auto.model.ShufflingFigureNumber;
import com.gow.beau.storage.ext.mapper.ShufflingFigureExtMapper;
import com.gow.beau.util.Base64Utils;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ShufflingFigureService
 * @Author lzn
 * @DATE 2019/9/23 10:10
 */
@Service
public class ShufflingFigureService {

    @Autowired
    private ShufflingFigureExtMapper shufflingFigureExtMapper;

    @Autowired
    private ShufflingFigureMapper shufflingFigureMapper;

    @Autowired
    private ShufflingFigureNumberMapper shufflingFigureNumberMapper;


    /**
     * 轮播图管理 - 轮播图列表信息 - 分页
     * */
    public PageInfo shufflingFigurePage(ShufflingFigurePageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        List<ShufflingFigureRsp> rspList = new ArrayList<>();
        List<ShufflingFigure> shufflingFigureList = shufflingFigureExtMapper.shufflingFigurePage(req);
        if(!CollectionUtils.isEmpty(shufflingFigureList)){
            for(ShufflingFigure shufflingFigure : shufflingFigureList){
                ShufflingFigureRsp rsp = this.getShufflingFigureRsp(shufflingFigure);
                rspList.add(rsp);
            }
        }
        pageInfo.setList(rspList);
        pageInfo.setRows(this.shufflingFigurePageCount(req));

        return pageInfo;
    }

    /**
     * 轮播图管理 - 轮播图列表信息 - 总数量
     * */
    private int shufflingFigurePageCount(ShufflingFigurePageReq req){
        return shufflingFigureExtMapper.shufflingFigurePageCount(req);
    }


    /**
     * 轮播图管理 - 轮播图列表信息 - 不分页
     * */
    public List<ShufflingFigureRsp> shufflingFigureList(String type){
        List<ShufflingFigureRsp> rspList = new ArrayList<>();
        String validityTime = DateUtil.dateToString(new Date(),DateUtil.PATTERN_YEAR_MONTH_DAY);
        List<ShufflingFigure> shufflingFigureList = shufflingFigureExtMapper.shufflingFigureList(type,validityTime);
        if(CollectionUtils.isEmpty(shufflingFigureList)){
            for(ShufflingFigure shufflingFigure : shufflingFigureList){
                ShufflingFigureRsp rsp = this.getShufflingFigureRsp(shufflingFigure);
                rspList.add(rsp);
            }
        }
        return rspList;
    }


    /**
     * 详情处理
     * */
    private ShufflingFigureRsp getShufflingFigureRsp(ShufflingFigure shufflingFigure){
        ShufflingFigureRsp rsp = new ShufflingFigureRsp();
        BeanUtil.copyProperties(shufflingFigure,rsp);
        rsp.setCreateTimeF(DateUtil.dateToString(shufflingFigure.getCreateTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));
        rsp.setValidityTimeF(DateUtil.dateToString(shufflingFigure.getValidityTime(),DateUtil.PATTERN_YEAR_MONTH_DAY));
        //类型（1：移动端首页轮播图，2：PC端）
        rsp.setTypeF(ShufflingFigureTypeService.getTypeText(shufflingFigure.getType()));
        if(null != shufflingFigure.getIsExternalUrl() && shufflingFigure.getIsExternalUrl().equals("0")){
            rsp.setBaseImage(Base64Utils.imageToBase64BySrc(shufflingFigure.getUrl()));
        }
        //是否过期，0：未过期，1：已过期
        if(null != shufflingFigure.getValidityTime() && shufflingFigure.getValidityTime().before(new Date())){
            rsp.setIsValidityTimeF(1);
        }
        return rsp;
    }


    /**
     * 详情
     * 根据id 查询信息
     * */
    public ShufflingFigureRsp getInfoById(Long id){
        ShufflingFigureRsp rsp = new ShufflingFigureRsp();
        //查询
        ShufflingFigure shufflingFigure = shufflingFigureMapper.selectByPrimaryKey(id);
        if(null == shufflingFigure){
            return rsp;
        }
        //处理字段详情
        rsp = this.getShufflingFigureRsp(shufflingFigure);
        return rsp;
    }


    /**
     * 新增
     * */
    public int add(ShufflingFigureAddReq req){
        ShufflingFigureNumber shufflingFigureNumber = shufflingFigureNumberMapper.selectByPrimaryKey(req.getId());
        if(null != shufflingFigureNumber && null != shufflingFigureNumber.getNumber() && shufflingFigureNumber.getNumber() > 0){
            //此类型的轮播图数量
            int count = shufflingFigureExtMapper.shufflingFigurePageCount(new ShufflingFigurePageReq(shufflingFigureNumber.getType()));
            //如果轮播图的数量已经大于等于设置的数量，则不允许新增
            if(count >= shufflingFigureNumber.getNumber()){
                return -1;
            }
        }
        //处理排序号和新增
        if(null == req.getSort() || req.getSort() == 0){
            Integer maxSort = shufflingFigureExtMapper.selectMaxSort();
            if(null == maxSort){
                req.setSort(1);
            }else{
                req.setSort(maxSort+1);
            }
        }
        ShufflingFigure shufflingFigure = new ShufflingFigure();
        shufflingFigure.setUrl(req.getUrl());
        shufflingFigure.setName(req.getName());
        shufflingFigure.setIsDelete("0");
        shufflingFigure.setSort(req.getSort());
        shufflingFigure.setType(shufflingFigureNumber.getType());
        shufflingFigure.setShufflingFigureNumberId(shufflingFigureNumber.getId());
        Date date = new Date();
        shufflingFigure.setCreateTime(date);
        shufflingFigure.setModifyTime(date);
        shufflingFigure.setIsExternalUrl(req.getIsExternalUrl());
        //过期时间为当前系统时间加一年
        shufflingFigure.setValidityTime(DateUtil.getTimeAddOrSubtract(DateUtil.CALENDAR_YEAR,1));
        return shufflingFigureMapper.insertSelective(shufflingFigure);
    }


    /**
     * 删除
     * */
    public int del(Long id){
        ShufflingFigure shufflingFigure = shufflingFigureMapper.selectByPrimaryKey(id);
        if(null == shufflingFigure){
            return 0;
        }
        shufflingFigure.setIsDelete("1");
        shufflingFigure.setDeleteTime(new Date());
        return shufflingFigureMapper.updateByPrimaryKeySelective(shufflingFigure);
    }


    /**
     * 设置 过期时间
     * */
    public int validityTimeSet(ShufflingFigureSetTimeReq req){
        if(null == req.getValidityTime() || req.getValidityTime().equals("")){
            return -1;
        }
        String[] parsePatterns = {"yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss"};
        try {
            req.setValidityTime(req.getValidityTime()+" 23:59:59");
            Date date = DateUtils.parseDate(req.getValidityTime(), parsePatterns);
            if(date.before(new Date())){
                return -2;
            }
            ShufflingFigure shufflingFigure = shufflingFigureMapper.selectByPrimaryKey(req.getId());
            if(null == shufflingFigure){
                return 0;
            }
            shufflingFigure.setValidityTime(date);
            shufflingFigure.setModifyTime(new Date());
            return shufflingFigureMapper.updateByPrimaryKeySelective(shufflingFigure);
        }catch (Exception e){
            return -3;
        }
    }


    /**
     * 根据id 查询过期时间
     * */
    public String getValidityTimeById(Long id){
        Date date = shufflingFigureExtMapper.selectValidityTimeById(id);
        if(null == date){
            return "";
        }
        return DateUtil.dateToString(date,DateUtil.PATTERN_YEAR_MONTH_DAY);
    }


    /**
     * 启用 或 禁用
     * */
    public int isUseInfo(Long id){
        ShufflingFigure shufflingFigure = shufflingFigureMapper.selectByPrimaryKey(id);
        if(null == shufflingFigure){
            return 0;
        }
        String isUse = null;
        if(shufflingFigure.getIsUse().equals("0")){
            isUse = "1";
        }else if(shufflingFigure.getIsUse().equals("1")){
            isUse = "0";
        }
        shufflingFigure.setIsUse(isUse);
        shufflingFigure.setModifyTime(new Date());
        return shufflingFigureMapper.updateByPrimaryKeySelective(shufflingFigure);
    }


    /**
     * 编辑
     * */
    public int edit(ShufflingFigureEditReq req){
        ShufflingFigure query = shufflingFigureMapper.selectByPrimaryKey(req.getId());
        if(null == query){
            return 0;
        }
        ShufflingFigure shufflingFigure = new ShufflingFigure();
        shufflingFigure.setId(query.getId());
        shufflingFigure.setUrl(req.getUrl());
        shufflingFigure.setIsExternalUrl(req.getIsExternalUrl());
        shufflingFigure.setSort(req.getSort());
        shufflingFigure.setName(req.getName());
        shufflingFigure.setModifyTime(new Date());
        return shufflingFigureMapper.updateByPrimaryKeySelective(shufflingFigure);
    }
}
