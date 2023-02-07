package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketActorEntity;
import org.dows.marketing.form.MarketActorForm;
import org.dows.marketing.service.MarketActorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销参与者(MarketActor)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销参与者")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketActor")
public class MarketActorRest implements MybatisCrudRest<MarketActorForm, MarketActorEntity, MarketActorService> {


}

