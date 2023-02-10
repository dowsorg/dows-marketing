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
 * 营销-自定义动态属性(MarketAttrName)实体类
 *
 * @author lait
 * @since 2023-02-06 18:31:08
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MarketAttrName对象", description = "营销-自定义动态属性")
@TableName("market_attr_name")
public class MarketAttrNameEntity  {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("营销名称ID")
    private String marketNameId;

    @ApiModelProperty("属性名")
    private String attrName;

    @ApiModelProperty("字段名")
    private String filedName;

    @ApiModelProperty("字段类型：string，int，long，decimal，double")
    private String filedTyp;

    @ApiModelProperty("索引类型： 0->非索引, 1->主键索引，2->唯一索引 3->普通索引")
    private Integer indexTyp;

    @ApiModelProperty("属性选择的类型:0->唯一，1->单选，2->多选")
    private Integer selectTyp;

    @ApiModelProperty("属性录入方式:0->手工录入，1->从列表中选取")
    private Integer inputTyp;

    @ApiModelProperty("数字类型参数的单位，非数字类型可以为空")
    private String unit;

    @ApiModelProperty("营销ID")
    private Long nameId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("时间戳")
    private Date dt;



}

