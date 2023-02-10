package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class MarketIdForm implements Serializable {

    @NotBlank(message = "营销id不能为空!")
    @ApiModelProperty(value = "营销id")
    private String marketNameId;
}
