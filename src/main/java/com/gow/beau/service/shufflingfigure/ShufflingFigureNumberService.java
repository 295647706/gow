package com.gow.beau.service.shufflingfigure;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberAddReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberEditReq;
import com.gow.beau.model.req.shufflingfigure.ShufflingFigureNumberPageReq;
import com.gow.beau.model.rsp.shufflingfigure.ShufflingFigureNumberRsp;
import com.gow.beau.storage.auto.mapper.ShufflingFigureMapper;
import com.gow.beau.storage.auto.mapper.ShufflingFigureNumberMapper;
import com.gow.beau.storage.auto.model.ShufflingFigureNumber;
import com.gow.beau.storage.ext.mapper.ShufflingFigureNumberExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ShufflingFigureNumberService
 * @Author lzn
 * @DATE 2019/9/23 11:13
 */
@Service
public class ShufflingFigureNumberService {

    @Autowired
    private ShufflingFigureNumberExtMapper shufflingFigureNumberExtMapper;

    @Autowired
    private ShufflingFigureNumberMapper shufflingFigureNumberMapper;

    /**
     * 轮播图管理 - 轮播图设置列表
     * */
    public PageInfo shufflingFigureNumberPage(ShufflingFigureNumberPageReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        List<ShufflingFigureNumber> shufflingFigureNumberList = shufflingFigureNumberExtMapper.shufflingFigureNumberPage(req);
        List<ShufflingFigureNumberRsp> rspList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(shufflingFigureNumberList)){
            for(ShufflingFigureNumber shuffling : shufflingFigureNumberList){
                rspList.add(this.getShufflingFigureNumberRsp(shuffling));
            }
        }
        pageInfo.setList(rspList);
        pageInfo.setRows(this.shufflingFigureNumberPageCount(req));

        return pageInfo;
    }

    /**
     * 轮播图管理 - 轮播图设置列表 - 总数量
     * */
    private int shufflingFigureNumberPageCount(ShufflingFigureNumberPageReq req){
        return shufflingFigureNumberExtMapper.shufflingFigureNumberPageCount(req);
    }

    /**
     * 轮播图管理 - 轮播图设置列表 - 不分页
     * */
    public List<ShufflingFigureNumberRsp> shufflingFigureNumberLit(){
        List<ShufflingFigureNumber> shufflingFigureNumberList = shufflingFigureNumberExtMapper.shufflingFigureNumberLit();
        List<ShufflingFigureNumberRsp> rspList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(shufflingFigureNumberList)){
            for(ShufflingFigureNumber shuffling : shufflingFigureNumberList){
                rspList.add(this.getShufflingFigureNumberRsp(shuffling));
            }
        }
        return rspList;
    }


    /**
     * 详情处理
     * */
    private ShufflingFigureNumberRsp getShufflingFigureNumberRsp(ShufflingFigureNumber shufflingFigureNumber){
        ShufflingFigureNumberRsp rsp = new ShufflingFigureNumberRsp();
        BeanUtil.copyProperties(shufflingFigureNumber,rsp);
        rsp.setCreateTimeF(DateUtil.dateToString(shufflingFigureNumber.getCreateTime(),DateUtil.PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS));
        //类型（1：移动端首页轮播图，2：PC端）
        rsp.setTypeF(ShufflingFigureTypeService.getTypeText(shufflingFigureNumber.getType()));
        return rsp;
    }

    /**
     * 新增
     * */
    public int add(ShufflingFigureNumberAddReq req){
        int count = shufflingFigureNumberExtMapper.selectCountByType(req.getType());
        if(count > 0){
            return -1;
        }
        ShufflingFigureNumber shufflingFigureNumber = new ShufflingFigureNumber();
        shufflingFigureNumber.setType(req.getType());
        shufflingFigureNumber.setNumber(req.getNumber());
        shufflingFigureNumber.setIsDelete("0");
        shufflingFigureNumber.setIsUse("0");
        Date date = new Date();
        shufflingFigureNumber.setCreateTime(date);
        shufflingFigureNumber.setModifyTime(date);
        return shufflingFigureNumberMapper.insertSelective(shufflingFigureNumber);
    }


    /**
     * 删除
     * */
    public int del(Integer id){
        ShufflingFigureNumber shuffling = shufflingFigureNumberMapper.selectByPrimaryKey(id);
        if(null == shuffling){
            return 0;
        }
        shuffling.setIsDelete("1");
        shuffling.setDeleteTime(new Date());
        return shufflingFigureNumberMapper.updateByPrimaryKeySelective(shuffling);
    }


    /**
     * 编辑
     * */
    public int edit(ShufflingFigureNumberEditReq req){
        ShufflingFigureNumber shuffling = shufflingFigureNumberMapper.selectByPrimaryKey(req.getId());
        if(null == shuffling){
            return 0;
        }
        shuffling.setNumber(req.getNumber());
        shuffling.setModifyTime(new Date());
        return shufflingFigureNumberMapper.updateByPrimaryKeySelective(shuffling);
    }


    /**
     * 启用 或 不启用
     * */
    public int isUse(Integer id){
        ShufflingFigureNumber shuffling = shufflingFigureNumberMapper.selectByPrimaryKey(id);
        if(null == shuffling){
            return 0;
        }
        String isUse = null;
        if(shuffling.getIsUse().equals("0")){
            isUse = "1";
        }else if(shuffling.getIsUse().equals("1")){
            isUse = "0";
        }
        shuffling.setIsUse(isUse);
        shuffling.setModifyTime(new Date());
        return shufflingFigureNumberMapper.updateByPrimaryKeySelective(shuffling);
    }


    /**
     * 轮播图设置数量
     * */
    public int getNumber(Integer id){
        ShufflingFigureNumber shuffling = shufflingFigureNumberMapper.selectByPrimaryKey(id);
        if(null == shuffling){
            return -1;
        }
        return shuffling.getNumber();
    }
}
