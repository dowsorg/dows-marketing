package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketProductEntity;
import org.dows.marketing.form.MarketProductForm;
import org.dows.marketing.service.MarketProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销关联产品(MarketProduct)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销关联产品")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketProduct")
public class MarketProductRest implements MybatisCrudRest<MarketProductForm, MarketProductEntity, MarketProductService> {


}

