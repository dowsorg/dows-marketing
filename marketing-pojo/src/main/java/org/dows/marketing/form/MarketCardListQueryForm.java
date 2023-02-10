package org.dows.marketing.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MarketCardListQueryForm {

    @ApiModelProperty(value = "储蓄卡号")
    private String cardNo;

    @ApiModelProperty(value = "客户编号")
    private String accountNo;

    @ApiModelProperty(value = "客户名称")
    private String accountName;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "门店id")
    private Long storeId;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
