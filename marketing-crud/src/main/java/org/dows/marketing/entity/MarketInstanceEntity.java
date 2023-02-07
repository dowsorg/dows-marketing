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
 * 营销实例(MarketInstance)实体类
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
@ApiModel(value = "MarketInstance对象", description = "营销实例")
@TableName("market_instance")
public class MarketInstanceEntity implements CrudEntity {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("营销名称ID")
    private Long marketNameId;

    @ApiModelProperty("营销名称")
    private String marketName;

    @ApiModelProperty("营销英文名称，表名")
    private String marketEnName;

    @ApiModelProperty("DDL动态创建营销对应的表")
    private String marketTable;

    @ApiModelProperty("租户ID")
    private Long tenantId;

    @ApiModelProperty("店铺No")
    private Long storeId;

    @ApiModelProperty("应用ID")
    private Long appId;

    @ApiModelProperty("账号ID")
    private Long accountId;

    @ApiModelProperty("使用说明")
    private String descr;

    @ApiModelProperty("h5链接")
    private String h5url;

    @ApiModelProperty("")
    private Date startTime;

    @ApiModelProperty("")
    private Date endTime;

    @ApiModelProperty("营销状态: 0-> 无效 1->有效")
    private Integer marketState;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

