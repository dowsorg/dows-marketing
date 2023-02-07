package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketAttrNameMapper;
import org.dows.marketing.entity.MarketAttrNameEntity;
import org.dows.marketing.service.MarketAttrNameService;
import org.springframework.stereotype.Service;


/**
 * 营销-自定义动态属性(MarketAttrName)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:08
 */
@Service("marketAttrNameService")
public class MarketAttrNameServiceImpl extends MybatisCrudServiceImpl<MarketAttrNameMapper, MarketAttrNameEntity> implements MarketAttrNameService {

}

