package com.gow.beau.model.rsp.category;

import lombok.Data;

import java.util.List;

/**
 * Date: 2019/2/15 15:48<br/>
 *
 * @author lzn
 */
@Data
public class CategoryListRsp {

    private Long categoryId;

    private String categoryName;

    private List<CategoryGoodsListRsp> categoryGoodsListRspList;
}
