package org.dows.marketing.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuhonger
 */
@Data
public class MarketAddNameBo implements Serializable {


    private static final long serialVersionUID = -3908731621398877030L;


    @ApiModelProperty(value = "营销code")
    private String marketCode;

    @ApiModelProperty(value = "适用门店")
    private List<Long> storeIds;

}
