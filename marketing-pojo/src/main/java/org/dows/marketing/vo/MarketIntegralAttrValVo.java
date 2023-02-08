package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MarketIntegralAttrValVo implements Serializable {
    private static final long serialVersionUID = 8464779291956613070L;

    @ApiModelProperty(value = "营销id")
    private String marketNameId;

    @ApiModelProperty(value = "1:积分现金比例 2:消费返积分比例")
    private Integer type;

    @ApiModelProperty(value = "比例名称")
    private String name;

    @ApiModelProperty(value = "积分换金额")
    private Integeral integeral;


    @ApiModelProperty(value = "金额返积分")
    private ReturnIntegeral returnIntegeral;


    @Data
    public static class ReturnIntegeral implements Serializable{

        private static final long serialVersionUID = 6833855923040066470L;

        @ApiModelProperty(value = "每消费")
        private BigDecimal useAmount;

        @ApiModelProperty(value = "返积分")
        private Integer returnInteger;
    }


    @Data
    public static class Integeral implements Serializable{
        private static final long serialVersionUID = -5717372494415022481L;

        @ApiModelProperty(value = "积分")
        private Integer integer;

        @ApiModelProperty(value = "等于")
        private BigDecimal amount;
    }
}
