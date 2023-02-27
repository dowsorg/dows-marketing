package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MarketProvideGiveQuery {

    @ApiModelProperty("客户编号")
    private Long userId;
    @ApiModelProperty("门店id")
    private Long storeId;
    @ApiModelProperty("客户姓名")
    private String name;
    @ApiModelProperty("优惠券名称")
    private String marketName;

    @ApiModelProperty(" 使用日期 - 开始日期")
    private Data startDate;

    @ApiModelProperty(" 使用日期 -  结束日")
    private Data endDate;

    @ApiModelProperty("当前页")
    private int current = 0;

    @ApiModelProperty("页面大小")
    private int size = 10;


}
