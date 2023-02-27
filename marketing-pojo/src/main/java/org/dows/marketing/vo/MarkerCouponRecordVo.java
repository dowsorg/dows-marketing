package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MarkerCouponRecordVo {
    @ApiModelProperty("客户编号")
    private String userId;

    @ApiModelProperty("客户姓名")
    private String name;

    @ApiModelProperty("领取方式")
    private String receiveMethod;

    @ApiModelProperty("领券时间")
    private String receiveDate;

    @ApiModelProperty("名称")
    private String marketName;

    @ApiModelProperty(value = "分类code-条目码-优惠卷类型")
    private String categoryCode;

    @ApiModelProperty("面额")
    private Integer couponAmount;

    @ApiModelProperty("满足使用")
    private Integer useAmount;

    @ApiModelProperty("有效期")
    private Integer expDate;

    @ApiModelProperty("到期日期")
    private Date reviceDate;

    @ApiModelProperty("门店id")
    private Long storeId;

    @ApiModelProperty(" 使用日期 - 开始日期")
    private Data startDate;

    @ApiModelProperty(" 使用日期 -  结束日")
    private Data endDate;

    @ApiModelProperty(" 优惠券状态-0：未使用，1：已使用,2:已过期")
    private Integer useStatus;

}
