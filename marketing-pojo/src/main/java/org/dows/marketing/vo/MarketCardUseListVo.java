package org.dows.marketing.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MarketCardUseListVo {

    @ApiModelProperty(value = "储蓄卡号")
    private String cardNo;

    @ApiModelProperty(value = "客户编号")
    private String accountNo;

    @ApiModelProperty(value = "客户名称")
    private String accountName;

    @ApiModelProperty(value = "适用店铺")
    private String useStoreName;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "已使用金额")
    private BigDecimal useAmount;

    @ApiModelProperty(value = "剩余金额")
    private BigDecimal surplusAmount;

    @ApiModelProperty(value = "创建时间")
    private Date dt;

}
