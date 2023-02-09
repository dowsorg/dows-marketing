package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MarketStoreVo implements Serializable {
    private static final long serialVersionUID = -2986854523402718765L;

    @ApiModelProperty(value = "门店标识-ID")
    private String storeId;
    @ApiModelProperty(value = "营销类型名称")
    private String categoryName;
    @ApiModelProperty(value = "营销分类ID-条目码")
    private String categoryCode;
    @ApiModelProperty(value = "是否有权限：0-无，1-有")
    private String hasAuth;


}
