package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketInstanceMapper;
import org.dows.marketing.entity.MarketInstanceEntity;
import org.dows.marketing.service.MarketInstanceService;
import org.springframework.stereotype.Service;


/**
 * 营销实例(MarketInstance)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:10
 */
@Service("marketInstanceService")
public class MarketInstanceServiceImpl extends MybatisCrudServiceImpl<MarketInstanceMapper, MarketInstanceEntity> implements MarketInstanceService {

}

