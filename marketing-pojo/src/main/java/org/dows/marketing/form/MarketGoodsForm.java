package org.dows.marketing.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 营销关联产品(MarketGoods)实体类
 *
 * @author lait
 * @since 2023-02-06 18:31:09
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MarketGoods对象", description = "营销关联产品")
public class MarketGoodsForm {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键id")
    private Long id;


    @ApiModelProperty("产品ID")
    private String productId;


    @ApiModelProperty("营销规则")
    private String ruleJson;


    @ApiModelProperty("营销ID")
    private Long marketId;


}

