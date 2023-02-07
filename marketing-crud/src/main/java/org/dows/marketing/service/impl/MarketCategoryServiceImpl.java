package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketCategoryMapper;
import org.dows.marketing.entity.MarketCategoryEntity;
import org.dows.marketing.service.MarketCategoryService;
import org.springframework.stereotype.Service;


/**
 * 营销类目(MarketCategory)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:09
 */
@Service("marketCategoryService")
public class MarketCategoryServiceImpl extends MybatisCrudServiceImpl<MarketCategoryMapper, MarketCategoryEntity> implements MarketCategoryService {

}

