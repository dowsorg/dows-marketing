package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MarketCouponForm implements Serializable {
    private static final long serialVersionUID = -298685452340456665L;

    @ApiModelProperty(value = "营销ID,新增为空，修改需要传")
    private Long id;

    @ApiModelProperty(value = "营销分类code-条目码-类型")
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
    private List<Long> storeIds;

    @ApiModelProperty(value = "是否启用：0-无，1-有")
    private Integer marketState;


}
