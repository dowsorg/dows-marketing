package org.dows.marketing.entity;

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
 * 营销-名称(MarketName)实体类
 *
 * @author lait
 * @since 2023-02-06 18:31:10
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MarketName对象", description = "营销-名称")
@TableName("market_name")
public class MarketNameEntity implements CrudEntity {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("类目ID")
    private Long categoryId;

    @ApiModelProperty("营销名称ID")
    private Long marketNameId;

    @ApiModelProperty("门店id")
    private Long storeId;

    @ApiModelProperty("是否启用 0:启用 1:禁用")
    private Integer enable;

    @ApiModelProperty("类目名称")
    private String categoryName;

    @ApiModelProperty("名称")
    private String marketName;

    @ApiModelProperty("营销英文名")
    private String marketCode;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("排序")
    private Integer sorted;

    @ApiModelProperty("描述")
    private String descr;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;
}

