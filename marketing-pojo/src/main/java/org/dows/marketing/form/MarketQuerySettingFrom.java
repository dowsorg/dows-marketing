package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class MarketQuerySettingFrom implements Serializable {
    private static final long serialVersionUID = -2986854334402718765L;

    @ApiModelProperty(value = "租户-ID")
    private String tenantId;

    @ApiModelProperty(value = "门店标识-ID")
    private String storeId;

    @NotBlank
    @ApiModelProperty(value = "营销分类ID-条目码")
    private String attrName;


}
