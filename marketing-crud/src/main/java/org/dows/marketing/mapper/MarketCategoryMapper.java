package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketCategoryEntity;

/**
 * 营销类目(MarketCategory)表数据库访问层
 *
 * @author lait
 * @since 2023-02-06 18:31:09
 */
@Mapper
public interface MarketCategoryMapper extends MybatisCrudMapper<MarketCategoryEntity> {

}

