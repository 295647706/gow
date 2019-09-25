package com.gow.beau.api.upload;

import com.gow.beau.model.rsp.upload.UploadRsp;
import com.gow.beau.service.imageurl.ImageUrlService;
import com.gow.beau.util.Base64Utils;
import net.sf.json.JSONObject;
import com.gow.beau.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUpload
 * @Author lzn
 * @DATE 2019/9/12 11:03
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUpload {

    @Autowired
    private ImageUrlService imageUrlService;


    /**
     * 图片保存域名地址
     * */
    private String getSaveImgPath(){
        return imageUrlService.getSaveImgPath();
    }

    /**
     * 图片上传
     * */
    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JSONObject uploadImg(@RequestParam("file") MultipartFile file){
        JSONObject jsonpObject = null;
        //返回对象
        UploadRsp rsp = new UploadRsp();
        if(null == file){
            rsp.setCode(1);
            rsp.setMsg("请选择上传图片");
        }
        try {
            //文件原名称
            String originalFilename = file.getOriginalFilename();
            //文件格式
            String ext = StringUtils.substringAfter(originalFilename, ".");
            String name = StringUtils.substringBefore(originalFilename,".");
            String url = this.getSaveImgPath();
            //新的图片名称
            name = name + "_" + CodeUtil.randomCode(4) + "." +ext;
            String filePath = url + name;
            //file
            File newFile = new File(filePath);
            //保存图片
            file.transferTo(newFile);

            //返回对象信息
            rsp.setCode(0);
            rsp.setMsg("上传成功");
            rsp.setPath(filePath);
            rsp.setName(name);
            String base64Image = Base64Utils.imageToBase64ByLocal(filePath);
            base64Image = "data:image/"+ext+";base64,"+base64Image;
            rsp.setData(base64Image);
        }catch (Exception e){
            rsp.setCode(-1);
            rsp.setMsg(e.getMessage());
        }
        //转json
        jsonpObject = JSONObject.fromObject(rsp);
        return jsonpObject;
    }
}
