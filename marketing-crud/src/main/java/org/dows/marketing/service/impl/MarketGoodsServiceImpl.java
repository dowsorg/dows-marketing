package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketGoodsMapper;
import org.dows.marketing.entity.MarketGoodsEntity;
import org.dows.marketing.service.MarketGoodsService;
import org.springframework.stereotype.Service;


/**
 * 营销关联产品(MarketGoods)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:09
 */
@Service("marketGoodsService")
public class MarketGoodsServiceImpl extends MybatisCrudServiceImpl<MarketGoodsMapper, MarketGoodsEntity> implements MarketGoodsService {

}

