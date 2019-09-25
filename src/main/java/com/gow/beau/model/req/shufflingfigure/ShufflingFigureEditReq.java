package com.gow.beau.model.req.shufflingfigure;

import lombok.Data;

/**
 * @ClassName ShufflingFigureEditReq
 * @Author lzn
 * @DATE 2019/9/25 16:13
 */
@Data
public class ShufflingFigureEditReq {

    private Long id;

    private String url;

    private Integer sort;

    private String name;

    private String isExternalUrl;
}
