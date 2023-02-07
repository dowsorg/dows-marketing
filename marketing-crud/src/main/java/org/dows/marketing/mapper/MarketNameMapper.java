package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketNameEntity;

/**
 * 营销-名称(MarketName)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:10
 */
@Mapper
public interface MarketNameMapper extends MybatisCrudMapper<MarketNameEntity> {

}

