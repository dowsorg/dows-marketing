package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MarketStoreFrom implements Serializable {
    private static final long serialVersionUID = -2986854523402718765L;

    @ApiModelProperty(value = "租户-ID")
    private String tenantId;

    @ApiModelProperty(value = "门店标识-ID")
    private String storeId;

}
