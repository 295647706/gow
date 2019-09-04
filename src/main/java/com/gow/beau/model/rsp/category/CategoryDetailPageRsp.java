package com.gow.beau.model.rsp.category;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Date: 2019/2/15 15:48<br/>
 *
 * @author lzn
 */
@Data
public class CategoryDetailPageRsp {

    private Long catId;

    private String catName;

    private String catIsShow;

    private Integer catSort;

    private String createTimeF;

    private List<CategoryGoodsListRsp> categoryGoodsListRspList;
}
