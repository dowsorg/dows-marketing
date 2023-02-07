package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.form.MarketNameForm;
import org.dows.marketing.service.MarketNameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销-名称(MarketName)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销-名称")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketName")
public class MarketNameRest implements MybatisCrudRest<MarketNameForm, MarketNameEntity, MarketNameService> {


}

