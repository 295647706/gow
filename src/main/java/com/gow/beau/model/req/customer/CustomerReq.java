package com.gow.beau.model.req.customer;

import com.gow.beau.model.data.User;
import lombok.Data;

/**
 * Date: 2019/2/18 14:17<br/>
 *
 * @author lzn
 */
@Data
public class CustomerReq extends User {

    private Long customerId;
}
