package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class MarketSettingFrom implements Serializable {
    private static final long serialVersionUID = -2986854523402718765L;

    @ApiModelProperty(value = "有id时要传，进行编辑")
    private Long id;

    @ApiModelProperty(value = "租户-ID，总部营销控制")
    private String tenantId;

    @NotBlank
    @ApiModelProperty(value = "营销分类ID-条目码")
    private String attrName;

    @NotBlank
    @ApiModelProperty(value = "是否有权限：off-无，on-有")
    private String attrVal;
}
