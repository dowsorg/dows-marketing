package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketInstanceEntity;
import org.dows.marketing.form.MarketInstanceForm;
import org.dows.marketing.service.MarketInstanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销实例(MarketInstance)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销实例")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketInstance")
public class MarketInstanceRest implements MybatisCrudRest<MarketInstanceForm, MarketInstanceEntity, MarketInstanceService> {


}

