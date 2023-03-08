package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MarketCouponVo implements Serializable {

    private static final long serialVersionUID = 2986866754777456665L;

    @ApiModelProperty("主键id")
    private String  id;

    @ApiModelProperty(value = "分类code-条目码-优惠卷类型")
    private Integer categoryCode;

    @ApiModelProperty("名称")
    private String marketName;

    @ApiModelProperty("面额")
    private Integer couponAmount;

    @ApiModelProperty("满足使用")
    private Integer useAmount;

    @ApiModelProperty("有效期")
    private Date expDate;

    @ApiModelProperty("发型量")
    private Integer provideNum;

    @ApiModelProperty("优惠卷剩余量")
    private Integer remainingQuantity;

    @ApiModelProperty("使用量")
    private Integer usedNum;

    @ApiModelProperty("领取方式")
    private String receiveMethod;

    @ApiModelProperty("推送方式")
    private String pushMode;

    @ApiModelProperty(value = "使用范围（门店标识-ID）")
    private String storeIds;

    @ApiModelProperty(value = "营销ID")
    private Long marketNameId;

    @ApiModelProperty(value = "租户ID")
    private String TenantId;

    @ApiModelProperty(value = "租户ID")
    private Date createTime;

    @ApiModelProperty(value = "开启状态：0没启用，1启用")
    private Integer status;

    @ApiModelProperty(value = "发放条件：0-新人登录，1-邀请好友，2-完善资料")
    private Integer sendEvent;
}
