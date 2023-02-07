package org.dows.marketing.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.marketing.mapper.MarketAttrValMapper;
import org.dows.marketing.entity.MarketAttrValEntity;
import org.dows.marketing.service.MarketAttrValService;
import org.springframework.stereotype.Service;


/**
 * 营销-自定义动态属性值(MarketAttrVal)表服务实现类
 *
 * @author lait
 * @since 2023-02-06 18:31:09
 */
@Service("marketAttrValService")
public class MarketAttrValServiceImpl extends MybatisCrudServiceImpl<MarketAttrValMapper, MarketAttrValEntity> implements MarketAttrValService {

}

