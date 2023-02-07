package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketActorEntity;

/**
 * 营销参与者(MarketActor)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:07
 */
@Mapper
public interface MarketActorMapper extends MybatisCrudMapper<MarketActorEntity> {

}

