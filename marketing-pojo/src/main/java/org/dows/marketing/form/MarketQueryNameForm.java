package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.marketing.bo.MarketCardAttrValBo;
import org.dows.marketing.bo.MarketIntegralAttValBo;
import org.dows.marketing.enums.MarketNameEnums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author liuhonger
 */
@Data
public class MarketQueryNameForm implements Serializable {

    private static final long serialVersionUID = -8267103559153458652L;


    @NotNull(message = "营销code不能为空!")
    @ApiModelProperty(value = "营销code")
    private MarketNameEnums codeEn;


    @NotNull(message = "适用门店不能为空!")
    @ApiModelProperty(value = "适用门店")
    private Long storeId;



}
