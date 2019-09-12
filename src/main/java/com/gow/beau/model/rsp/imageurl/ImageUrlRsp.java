package com.gow.beau.model.rsp.imageurl;

import com.gow.beau.storage.auto.model.ImageUrl;
import lombok.Data;

/**
 * @ClassName ImageUrlRsp
 * @Author lzn
 * @DATE 2019/9/12 16:54
 */
@Data
public class ImageUrlRsp extends ImageUrl {

    private String createTimeF;

    private String modifyTimeF;
}
