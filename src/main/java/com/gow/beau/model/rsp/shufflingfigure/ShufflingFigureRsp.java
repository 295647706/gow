package com.gow.beau.model.rsp.shufflingfigure;

import com.gow.beau.storage.auto.model.ShufflingFigure;
import lombok.Data;

/**
 * @ClassName ShufflingFigureRsp
 * @Author lzn
 * @DATE 2019/9/24 11:22
 */
@Data
public class ShufflingFigureRsp extends ShufflingFigure {

    private String baseImage;

    private String createTimeF;

    private String typeF;

    private String validityTimeF;

    //是否过期，0：未过期，1：已过期
    private int isValidityTimeF = 0;
}
