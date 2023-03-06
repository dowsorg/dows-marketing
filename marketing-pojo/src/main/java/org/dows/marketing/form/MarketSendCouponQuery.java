package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class MarketSendCouponQuery {

    @ApiModelProperty("赠送规则 (\"自动领取\",\"11\"),\n" +
            " (\"手动领取\",\"12\"),")
    private String receiveMethod;
    @ApiModelProperty("门店id")
    private Long storeId;
    @ApiModelProperty("操作人id")
    private Long userId;
    @ApiModelProperty("优惠券名称")
    private String marketName;

    @ApiModelProperty("当前页")
    private int current = 0;

    @ApiModelProperty("页面大小")
    private int size = 10;

}
