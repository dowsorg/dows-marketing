package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketActorRecordEntity;

/**
 * 营销参与者记录(MarketActorRecord)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:08
 */
@Mapper
public interface MarketActorRecordMapper extends MybatisCrudMapper<MarketActorRecordEntity> {

}

