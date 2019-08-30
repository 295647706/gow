package com.gow.beau.model.req.category;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * @ClassName CategoryListPageReq
 * @Author lzn
 * @DATE 2019/8/30 15:27
 */
@Data
public class CategoryListPageReq extends PageInfo {

    private String catName;

    private String catIsShow;
}
