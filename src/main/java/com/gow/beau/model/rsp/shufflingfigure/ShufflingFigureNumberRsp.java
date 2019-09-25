package com.gow.beau.model.rsp.shufflingfigure;

import com.gow.beau.storage.auto.model.ShufflingFigureNumber;
import lombok.Data;

/**
 * @ClassName ShufflingFigureNumberRsp
 * @Author lzn
 * @DATE 2019/9/23 13:35
 */
@Data
public class ShufflingFigureNumberRsp extends ShufflingFigureNumber {

    private String createTimeF;

    private String typeF;
}
