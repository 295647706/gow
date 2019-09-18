package com.gow.beau.model.req.information;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * @ClassName InformationListPageReq
 * @Author lzn
 * @DATE 2019/9/16 17:39
 */
@Data
public class InformationListPageReq extends PageInfo {

    private String title;

    private String isSubmit;
}
