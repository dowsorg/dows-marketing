package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.marketing.bo.MarketIntegralAttValBo;

import java.io.Serializable;

@Data
public class MarketIntegralNameForm extends MarketAddNameForm implements Serializable {
    private static final long serialVersionUID = -2692125100316987001L;

    @ApiModelProperty(value = "积分")
    private MarketIntegralAttValBo integralAttValBo;
}
