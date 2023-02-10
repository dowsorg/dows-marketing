package org.dows.marketing.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MarketCardRechargeListVo {

    @ApiModelProperty(value = "储蓄卡号")
    private String cardNo;

    @ApiModelProperty(value = "客户编号")
    private String accountNo;

    @ApiModelProperty(value = "客户名称")
    private String accountName;

    @ApiModelProperty(value = "充值店铺")
    private String rechargeStoreName;

    @ApiModelProperty(value = "充值金额")
    private BigDecimal rechargeAmount;

    @ApiModelProperty(value = "赠送金额")
    private BigDecimal giveAmount;

    @ApiModelProperty(value = "充值时间")
    private Date dt;

}
