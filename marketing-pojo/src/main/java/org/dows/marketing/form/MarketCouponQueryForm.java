package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MarketCouponQueryForm  implements Serializable {
    private static final long serialVersionUID = -2986854523223189665L;

    @ApiModelProperty("名称")
    private String marketName;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty(value = "是否启用：0-无，1-有")
    private Integer marketState;

    @ApiModelProperty("门店id")
    private Long storeId;

    @ApiModelProperty("当前页")
    private int current = 0;

    @ApiModelProperty("页面大小")
    private int size = 10;

    @ApiModelProperty("优惠卷类型：12001-定向发卷，12002-全体发卷，12003-叠加卷")
    private Integer categoryCode;
}
