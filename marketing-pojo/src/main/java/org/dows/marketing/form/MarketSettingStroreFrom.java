package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class MarketSettingStroreFrom implements Serializable {
    private static final long serialVersionUID = -2986854523402718765L;

    @ApiModelProperty(value = "有id时要传，进行编辑")
    private Long id;

    @ApiModelProperty(value = "租户-ID，总部营销控制")
    private String tenantId;

    @ApiModelProperty(value = "门店-ID，门店营销")
    private Long storeId;

    @NotBlank
    @ApiModelProperty(value = "营销分类ID-条目码")
    private String attrName;

    @NotBlank
    @ApiModelProperty(value = "是否有权限：off-无，on-有")
    private String attrVal;

    public MarketSettingStroreFrom(Long id, String tenantId, Long nameId, String attrName, String attrVal) {
        this.id = id;
        this.tenantId = tenantId;
        this.storeId = nameId;
        this.attrName = attrName;
        this.attrVal = attrVal;
    }
}
