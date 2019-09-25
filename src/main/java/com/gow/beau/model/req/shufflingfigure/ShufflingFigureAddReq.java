package com.gow.beau.model.req.shufflingfigure;

import lombok.Data;

/**
 * @ClassName ShufflingFigureAddReq
 * @Author lzn
 * @DATE 2019/9/23 17:31
 */
@Data
public class ShufflingFigureAddReq {

    private Integer id;

    private String url;

    private Integer sort;

    private String name;

    private String isExternalUrl;
}
