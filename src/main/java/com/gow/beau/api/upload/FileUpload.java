package com.gow.beau.api.upload;

import com.gow.beau.model.rsp.upload.UploadRsp;
import com.gow.beau.service.imageurl.ImageUrlService;
import com.gow.beau.util.Base64Utils;
import com.gow.beau.util.ImageUtil;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;
import com.gow.beau.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUpload
 * @Author lzn
 * @DATE 2019/9/12 11:03
 */
@Api(tags = "数据 - 后台管理 - 文件上传")
@RestController
@RequestMapping("/fileUpload")
public class FileUpload {

    //图片宽高
    private static final int WIDTH = 1080;
    private static final int HEIGHT = 460;

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
            rsp.setMsg("<span style='color: #ee7800;'>请选择上传图片</span>");
        }else {
            try {
                //获取图片缓冲类
                BufferedImage bufferedImage = ImageUtil.getBufferedImage(file.getInputStream());
                if (null == bufferedImage) {
                    rsp.setCode(1);
                    rsp.setMsg("<span style='color: #ee7800;'>请选择上传图片</span>");
                    return JSONObject.fromObject(rsp);
                }
                //获取图片宽高
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                if (width < WIDTH && height < HEIGHT) {
                    rsp.setCode(1);
                    rsp.setMsg("<span style='color: #ee7800;'>图片宽高建议在：1080*460</span>");
                    return JSONObject.fromObject(rsp);
                }
                //保存图片
                //文件原名称
                String originalFilename = file.getOriginalFilename();
                //文件格式
                String ext = StringUtils.substringAfter(originalFilename, ".");
                String name = StringUtils.substringBefore(originalFilename, ".");
                String url = this.getSaveImgPath();
                //新的图片名称
                name = name + "_" + CodeUtil.randomCode(4) + "." + ext;
                String filePath = url + name;
                //file
                File newFile = new File(filePath);

                if(width > WIDTH || height > HEIGHT){
                    //压缩保存
                    Image image = ImageIO.read(file.getInputStream());
                    ImageUtil.reduceImage(image,filePath,WIDTH,HEIGHT);
                }else {
                    //正常保存
                    //保存图片
                    file.transferTo(newFile);
                }

                //返回对象信息
                rsp.setCode(0);
                rsp.setMsg("<span style='color: #ee7800;'>上传成功</span>");
                rsp.setPath(filePath);
                rsp.setName(name);
                String base64Image = Base64Utils.imageToBase64ByLocal(filePath);
                base64Image = "data:image/" + ext + ";base64," + base64Image;
                rsp.setData(base64Image);
            } catch (Exception e) {
                rsp.setCode(-1);
                rsp.setMsg(e.getMessage());
            }
        }
        //转json
        jsonpObject = JSONObject.fromObject(rsp);
        return jsonpObject;
    }
}
