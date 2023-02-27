package org.dows.marketing.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.framework.crud.mybatis.CrudEntity;

import java.util.Date;

/**
 * 营销参与者(MarketActor)实体类
 *
 * @author lait
 * @since 2023-02-06 18:31:07
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MarketActor对象", description = "营销参与者")
@TableName("market_actor")
public class MarketActorEntity  {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("账号id")
    private Long accountId;

    @ApiModelProperty("营销规则")
    private String ruleJson;

    @ApiModelProperty("营销ID")
    private Long marketId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("时间戳")
    private Date dt;

    @ApiModelProperty("使用状态-0：未使用，1：已使用,2:已过期")
    private Integer useStatus;


}

