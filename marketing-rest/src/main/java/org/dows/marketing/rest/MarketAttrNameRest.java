package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketAttrNameEntity;
import org.dows.marketing.form.MarketAttrNameForm;
import org.dows.marketing.service.MarketAttrNameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销-自定义动态属性(MarketAttrName)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销-自定义动态属性")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketAttrName")
public class MarketAttrNameRest implements MybatisCrudRest<MarketAttrNameForm, MarketAttrNameEntity, MarketAttrNameService> {


}

