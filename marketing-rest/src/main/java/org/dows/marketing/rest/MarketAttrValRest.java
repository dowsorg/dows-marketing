package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketAttrValEntity;
import org.dows.marketing.form.MarketAttrValForm;
import org.dows.marketing.service.MarketAttrValService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销-自定义动态属性值(MarketAttrVal)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销-自定义动态属性值")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketAttrVal")
public class MarketAttrValRest implements MybatisCrudRest<MarketAttrValForm, MarketAttrValEntity, MarketAttrValService> {


}

