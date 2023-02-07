package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketAttrValEntity;

/**
 * 营销-自定义动态属性值(MarketAttrVal)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:09
 */
@Mapper
public interface MarketAttrValMapper extends MybatisCrudMapper<MarketAttrValEntity> {

}

