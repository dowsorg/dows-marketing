package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketAttrNameEntity;

/**
 * 营销-自定义动态属性(MarketAttrName)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:08
 */
@Mapper
public interface MarketAttrNameMapper extends MybatisCrudMapper<MarketAttrNameEntity> {

}

