package com.gow.beau.model.rsp.category;

import com.gow.beau.storage.auto.model.Category;
import lombok.Data;

/**
 * @ClassName CategoryListPageRsp
 * @Author lzn
 * @DATE 2019/8/30 15:48
 */
@Data
public class CategoryListPageRsp extends Category {

    private String createTimeF;
}
