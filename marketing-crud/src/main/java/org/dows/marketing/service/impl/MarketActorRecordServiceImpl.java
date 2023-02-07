package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketActorRecordMapper;
import org.dows.marketing.entity.MarketActorRecordEntity;
import org.dows.marketing.service.MarketActorRecordService;
import org.springframework.stereotype.Service;


/**
 * 营销参与者记录(MarketActorRecord)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:08
 */
@Service("marketActorRecordService")
public class MarketActorRecordServiceImpl extends MybatisCrudServiceImpl<MarketActorRecordMapper, MarketActorRecordEntity> implements MarketActorRecordService {

}

