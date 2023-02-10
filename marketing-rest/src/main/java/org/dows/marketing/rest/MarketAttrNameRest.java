package org.dows.marketing.rest;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.entity.MarketAttrNameEntity;
import org.dows.marketing.form.MarketAddNameForm;
import org.dows.marketing.form.MarketAttrNameForm;
import org.dows.marketing.service.MarketAttrNameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
public class MarketAttrNameRest  {


}

