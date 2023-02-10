package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketActorRecordEntity;
import org.dows.marketing.form.MarketActorRecordForm;
import org.dows.marketing.service.MarketActorRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销参与者记录(MarketActorRecord)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销参与者记录")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketActorRecord")
public class MarketActorRecordRest  {


}

