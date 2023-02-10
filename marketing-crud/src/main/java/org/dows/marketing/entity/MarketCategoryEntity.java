package org.dows.marketing.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.framework.crud.mybatis.CrudEntity;

/**
 * 营销类目(MarketCategory)实体类
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
@ApiModel(value = "MarketCategory对象", description = "营销类目")
@TableName("market_category")
public class MarketCategoryEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("父ID")
    private Long pid;

    @ApiModelProperty("分类名称如：1:获客拉新、2:下单转化、3:提高客单、4:复购留存、5:....(数据字典获取)")
    private String categoryName;

    @ApiModelProperty("类目码")
    private Integer categoryCode;

    @ApiModelProperty("层级")
    private Integer tier;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("时间戳")
    private Date dt;



}

