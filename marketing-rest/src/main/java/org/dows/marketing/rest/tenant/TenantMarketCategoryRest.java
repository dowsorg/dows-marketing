package org.dows.marketing.rest.tenant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.entity.MarketCategoryEntity;
import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.service.MarketCategoryService;
import org.dows.marketing.vo.MarketCategoryVo;
import org.dows.marketing.vo.MarketStoreVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
* 营销类目(MarketCategory)表控制层
*
* @author 
* @date 
*/
@Api(tags = "营销-优惠卷管理")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/marketCategory")
public class TenantMarketCategoryRest {

    private final MarketCategoryService marketCategoryService;


    @PostMapping("/getCouponList")
    @ApiOperation("优惠卷类型列表")
    public  Response<List<MarketCategoryEntity>> getCouponList(){

        List<MarketCategoryEntity> list = marketCategoryService.lambdaQuery().eq(MarketCategoryEntity::getPid,3L)
                .orderByAsc(MarketCategoryEntity::getTier).list();

        return Response.ok(list);
    }

}

