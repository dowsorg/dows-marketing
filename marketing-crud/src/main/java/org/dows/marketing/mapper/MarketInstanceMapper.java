package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketInstanceEntity;

/**
 * 营销实例(MarketInstance)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:10
 */
@Mapper
public interface MarketInstanceMapper extends MybatisCrudMapper<MarketInstanceEntity> {

}

