package org.dows.marketing.form;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 营销-自定义动态属性值(MarketAttrVal)实体类
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
@ApiModel(value = "MarketAttrVal对象", description = "营销-自定义动态属性值")
public class MarketAttrValForm {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键id")
    private Long id;


    @ApiModelProperty("属性值")
    private String attrVal;


    @ApiModelProperty("手动输入属性值（attrVal）的自定义值")
    private String definedVal;


    @ApiModelProperty("属性ID")
    private Long attrNameId;


}

