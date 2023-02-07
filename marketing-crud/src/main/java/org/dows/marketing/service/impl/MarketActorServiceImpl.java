package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketActorMapper;
import org.dows.marketing.entity.MarketActorEntity;
import org.dows.marketing.service.MarketActorService;
import org.springframework.stereotype.Service;


/**
 * 营销参与者(MarketActor)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:07
 */
@Service("marketActorService")
public class MarketActorServiceImpl extends MybatisCrudServiceImpl<MarketActorMapper, MarketActorEntity> implements MarketActorService {

}

