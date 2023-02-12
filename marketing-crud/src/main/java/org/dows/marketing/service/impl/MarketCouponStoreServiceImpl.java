package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.entity.MarketCouponStoreEntity;
import org.dows.marketing.mapper.MarketCouponStoreMapper;
import org.dows.marketing.service.MarketCouponStoreService;
import org.springframework.stereotype.Service;


@Service("marketCouponStoreService")
public class MarketCouponStoreServiceImpl extends MybatisCrudServiceImpl<MarketCouponStoreMapper, MarketCouponStoreEntity> implements MarketCouponStoreService {

}

