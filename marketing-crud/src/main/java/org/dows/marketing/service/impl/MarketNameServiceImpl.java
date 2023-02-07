package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketNameMapper;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.service.MarketNameService;
import org.springframework.stereotype.Service;


/**
 * 营销-名称(MarketName)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:10
 */
@Service("marketNameService")
public class MarketNameServiceImpl extends MybatisCrudServiceImpl<MarketNameMapper, MarketNameEntity> implements MarketNameService {

}

