package com.gow.beau.model.req.payment;

import com.gow.beau.model.data.PageInfo;
import lombok.Data;

/**
 * @ClassName PayMentListReq
 * @Author lzn
 * @DATE 2019/9/3 10:35
 */
@Data
public class PayMentListReq extends PageInfo {

    private String useType;
}
