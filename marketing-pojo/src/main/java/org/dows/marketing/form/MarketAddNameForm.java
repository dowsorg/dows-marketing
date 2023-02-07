package org.dows.marketing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.marketing.enums.MarketNameEnums;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author liuhonger
 */
@Data
public class MarketAddNameForm implements Serializable {

    private static final long serialVersionUID = -8267103559153458652L;


    @NotNull(message = "营销code不能为空!")
    @ApiModelProperty(value = "营销code")
    private MarketNameEnums codeEn;


    @NotNull(message = "适用门店不能为空!")
    @Size(min = 1,message = "适用门店不能为空")
    @ApiModelProperty(value = "适用门店")
    private List<Long> storeIds;

}
