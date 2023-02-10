package org.dows.marketing.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketCategoryEntity;
import org.dows.marketing.form.MarketCategoryForm;
import org.dows.marketing.service.MarketCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 营销类目(MarketCategory)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销类目")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("marketCategory")
public class MarketCategoryRest  {


}

