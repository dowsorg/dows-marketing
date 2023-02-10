package org.dows.marketing.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 营销类目(MarketCategory)实体类
 *
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
@ApiModel(value = "MarketCategory对象", description = "营销类目")
public class MarketCategoryVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键id")
    private Long id;


    @ApiModelProperty("父ID")
    private Long pid;


    @ApiModelProperty("分类名称如：1:获客拉新、2:下单转化、3:提高客单、4:复购留存、5:....(数据字典获取)")
    private Integer categoryName;


    @ApiModelProperty("类目码")
    private Integer categoryCode;


    @ApiModelProperty("层级")
    private Integer tier;


}

