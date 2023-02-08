package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.marketing.bo.MarketCardAttrValBo;

import java.io.Serializable;

@Data
public class MarketCardNameForm extends MarketAddNameForm implements Serializable {

    private static final long serialVersionUID = 6864667280817300648L;
    @ApiModelProperty(value = "储蓄卡")
    private MarketCardAttrValBo cardAttValBo;
}
