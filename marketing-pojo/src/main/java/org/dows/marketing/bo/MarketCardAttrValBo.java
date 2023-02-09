package org.dows.marketing.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MarketCardAttrValBo implements Serializable {


    private static final long serialVersionUID = -4447897423102538413L;

    @NotNull(message = "充值不能为空!")
    @ApiModelProperty(value = "充值")
    private BigDecimal recharge;

    @NotNull(message = "实际到账不能为空!")
    @ApiModelProperty(value = "实际到账")
    private BigDecimal amount;


}
