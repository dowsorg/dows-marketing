package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.marketing.bo.MarketCardAttrValBo;

import java.io.Serializable;

@Data
public class MarketCardAttrValVo implements Serializable {
    private static final long serialVersionUID = -2986854550602718765L;

    @ApiModelProperty(value = "营销id")
    private String marketNameId;

    @ApiModelProperty(value = "充值套餐")
    private String name;

    @ApiModelProperty(value = "充值套餐属性")
    private MarketCardAttrValBo cardAttrValBo;
}
