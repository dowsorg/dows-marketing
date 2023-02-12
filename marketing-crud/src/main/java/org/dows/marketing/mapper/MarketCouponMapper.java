package org.dows.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.marketing.entity.MarketCouponEntity;


@Mapper
public interface MarketCouponMapper extends MybatisCrudMapper<MarketCouponEntity> {

}

