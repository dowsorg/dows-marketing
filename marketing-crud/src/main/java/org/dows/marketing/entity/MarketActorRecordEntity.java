package org.dows.marketing.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 营销参与者记录(MarketActorRecord)实体类
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
@ApiModel(value = "MarketActorRecord对象", description = "营销参与者记录")
@TableName("market_actor_record")
public class MarketActorRecordEntity  {

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


}

