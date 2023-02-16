package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SentCouponForm {
    private static final long serialVersionUID = -298234344502718765L;

    @ApiModelProperty("优惠卷id")
    private Long couponId;

    @ApiModelProperty("用户id")
    private List<Long> userIds;

}
