package org.dows.marketing.rest;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.form.MarketAddNameForm;
import org.dows.marketing.form.MarketNameForm;
import org.dows.marketing.form.MarketQueryNameForm;
import org.dows.marketing.service.MarketNameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
public class MarketNameRest  {


    private final MarketNameApiService nameApiService;


}

