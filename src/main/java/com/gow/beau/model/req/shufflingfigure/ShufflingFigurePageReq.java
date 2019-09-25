package com.gow.beau.model.req.shufflingfigure;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * @ClassName ShufflingFigurePageReq
 * @Author lzn
 * @DATE 2019/9/23 10:30
 */
@Data
public class ShufflingFigurePageReq extends PageInfo {

    private String type;

    private Integer shufflingFigureNumberId;

    public ShufflingFigurePageReq(){}

    public ShufflingFigurePageReq(String type){
        this.type = type;
    }
}
