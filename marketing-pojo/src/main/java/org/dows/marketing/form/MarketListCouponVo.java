package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MarketListCouponVo implements Serializable {
    private static final long serialVersionUID = -298685452340456665L;

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty(value = "营销分类code-条目码-类型")
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
    private List<Long> storeIds;

    @ApiModelProperty(value = "是否启用：0-无，1-有")
    private Integer marketState;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "门店标识-ID")
    private Long storeId;

    @ApiModelProperty(value = "开启状态：0没启用，1启用")
    private Integer status;

    @ApiModelProperty(value = "开启状态：0没启用，1启用")
    private String storeName;

}
