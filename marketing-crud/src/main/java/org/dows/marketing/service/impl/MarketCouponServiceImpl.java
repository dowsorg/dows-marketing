package org.dows.marketing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.entity.MarketCouponEntity;
import org.dows.marketing.entity.MarketCouponStoreEntity;
import org.dows.marketing.form.MarketListCouponVo;
import org.dows.marketing.mapper.MarketCouponMapper;
import org.dows.marketing.mapper.MarketCouponStoreMapper;
import org.dows.marketing.service.MarketCouponService;
import org.dows.marketing.service.MarketCouponStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("marketCouponService")
public class MarketCouponServiceImpl extends MybatisCrudServiceImpl<MarketCouponMapper, MarketCouponEntity> implements MarketCouponService {

}

