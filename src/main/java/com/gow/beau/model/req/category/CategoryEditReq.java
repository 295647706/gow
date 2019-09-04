package com.gow.beau.model.req.category;

import lombok.Data;

/**
 * @ClassName CategoryAddReq
 * @Author lzn
 * @DATE 2019/8/30 16:31
 */
@Data
public class CategoryEditReq {

    private Long catId;

    private String catName;

    private String catIsShow;

    private Integer catSort;

}
