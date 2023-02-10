package org.dows.marketing.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MarketCardAttrValBo  {

    @NotNull(message = "充值不能为空!")
    @ApiModelProperty(value = "充值")
    private BigDecimal recharge;

    @NotNull(message = "实际到账不能为空!")
    @ApiModelProperty(value = "实际到账")
    private BigDecimal amount;

    @NotNull(message = "开始日期不能为空!")
    @ApiModelProperty(value = "开始日期")
    private Date startTime;

    @NotNull(message = "结束日期不能为空!")
    @ApiModelProperty(value = "结束日期")
    private Date endTime;


}
