package org.dows.marketing.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MarketCouponEntity", description = "营销-优惠卷")
@TableName("market_coupon")
public class MarketCouponEntity {


    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty(value = "分类code-条目码-优惠卷类型")
    private String categoryCode;

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
    private DateTime createTime;

    @ApiModelProperty(value = "开启状态：0没启用，1启用")
    private Integer status;

}