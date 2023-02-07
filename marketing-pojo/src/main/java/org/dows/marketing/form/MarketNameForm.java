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
public class MarketNameForm {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键id")
    private Long id;


    @ApiModelProperty("类目ID")
    private Long categoryId;


    @ApiModelProperty("营销名称ID")
    private String marketNameId;


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


}

