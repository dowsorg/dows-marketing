package org.dows.marketing.rest.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.service.MarketCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "营销-用户-优惠卷")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("user/marketing/coupon")
public class TenantCouponMarketingRest {

    private final MarketCategoryService marketCategoryService;


    @PutMapping("/addCoupon")
    @ApiOperation("优惠卷-增加")
    public Response<Boolean> addCoupon(){


        return Response.ok();
    }

    @GetMapping ("/getCouponList")
    @ApiOperation("优惠卷-列表")
    public Response getCouponList(){


        return Response.ok();
    }

    @GetMapping ("/getCouponRecordList")
    @ApiOperation("优惠卷-领取记录列表")
    public Response getCouponRecordList(){


        return Response.ok();
    }

    @GetMapping ("/provideGiveList")
    @ApiOperation("优惠卷-发放记录列表")
    public Response provideGiveList(){


        return Response.ok();
    }


}
