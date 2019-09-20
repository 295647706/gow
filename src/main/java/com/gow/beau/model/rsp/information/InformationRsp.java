package com.gow.beau.model.rsp.information;

import com.gow.beau.storage.auto.model.Information;
import lombok.Data;

/**
 * @ClassName InformationListPageRsp
 * @Author lzn
 * @DATE 2019/9/16 17:41
 */
@Data
public class InformationRsp extends Information {

    private String createTimeF;

    private String modifyTimeF;

    private String toViewNumberF;

    private String evaluateNumberF;

    private int isFocus = 0;
}
