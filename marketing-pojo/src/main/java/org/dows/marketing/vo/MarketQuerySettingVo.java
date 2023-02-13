package org.dows.marketing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.marketing.bo.MarketCardAttrValBo;
import org.dows.marketing.form.MarketSettingStroreFrom;

import java.io.Serializable;
import java.util.List;

@Data
public class MarketQuerySettingVo implements Serializable {
    private static final long serialVersionUID = -2986854559875318765L;

    @ApiModelProperty(value = "总部总开关")
    private MarketSettingStroreFrom settingStore;

    @ApiModelProperty(value = "所有门店开关")
    private List<MarketSettingStroreFrom> allStoreSetting;

}
