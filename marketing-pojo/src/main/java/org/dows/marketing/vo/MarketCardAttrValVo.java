package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MarketCardAttrValVo implements Serializable {
    private static final long serialVersionUID = -2986854550602718765L;

    @ApiModelProperty(value = "营销id")
    private String marketNameId;

    @ApiModelProperty(value = "充值套餐")
    private String name;

    @ApiModelProperty(value = "充值套餐属性")
    private CardAttrVal cardAttrVal;

    @Data
    public static class CardAttrVal implements Serializable{

        private static final long serialVersionUID = 4694750280521822577L;
        //@NotNull(message = "充值不能为空!")
        @ApiModelProperty(value = "充值")
        private BigDecimal recharge;

        //@NotNull(message = "实际到账不能为空!")
        @ApiModelProperty(value = "实际到账")
        private BigDecimal amount;
    }
}
