package com.gow.beau.service.imageurl;

import com.gow.beau.model.rsp.imageurl.ImageUrlRsp;
import com.gow.beau.storage.auto.mapper.ImageUrlMapper;
import com.gow.beau.storage.auto.model.ImageUrl;
import com.gow.beau.storage.ext.mapper.ImageUrlExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName ImageUrlService
 * @Author lzn
 * @DATE 2019/9/12 16:19
 */
@Service
public class ImageUrlService {

    @Autowired
    private ImageUrlExtMapper imageUrlExtMapper;

    @Autowired
    private ImageUrlMapper imageUrlMapper;

    public ImageUrlRsp getImageUrl(){
        ImageUrl imageUrl = imageUrlExtMapper.getImageUrl();
        if(null == imageUrl){
            return new ImageUrlRsp();
        }
        ImageUrlRsp rsp = new ImageUrlRsp();
        BeanUtil.copyProperties(imageUrl,rsp);
        rsp.setCreateTimeF(DateUtil.dateToString2(imageUrl.getCreateTime()));
        rsp.setModifyTimeF(DateUtil.dateToString2(imageUrl.getModifyTime()));
        return rsp;
    }


    /**
     * 新增或修改
     * */
    public int updateAddUrl(ImageUrl imageUrl){
        if(null == imageUrl || null == imageUrl.getUrl()){
            return 0;
        }
        ImageUrl query = imageUrlExtMapper.getImageUrl();
        if(null == query){
            imageUrl.setId(null);
            Date date = new Date();
            imageUrl.setCreateTime(date);
            imageUrl.setModifyTime(date);
            return imageUrlMapper.insertSelective(imageUrl);
        }else{
            if(!query.getUrl().trim().equals(imageUrl.getUrl().trim()) || !query.getNote().trim().equals(imageUrl.getNote().trim())){
                query.setUrl(imageUrl.getUrl()==null?null:imageUrl.getUrl());
                query.setNote(imageUrl.getNote()==null?null:imageUrl.getNote());
                query.setModifyTime(new Date());
                return imageUrlMapper.updateByPrimaryKeySelective(imageUrl);
            }
        }
        return 0;
    }


    /**
     * 图片保存域名地址
     * */
    public String getSaveImgPath(){
        ImageUrl query = imageUrlExtMapper.getImageUrl();
        if(null == query){
            return null;
        }
        return query.getUrl();
    }
}
