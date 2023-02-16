package org.dows.marketing.rest.tenant;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.api.MarketCouponApi;
import org.dows.marketing.api.MarketSettingApi;
import org.dows.marketing.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "【门店APP】营销-优惠卷")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/marketing/coupon/app")
public class TenantAppCouponMarketingRest {
    @Autowired
    MarketCouponApi marketCouponApi;
    @Autowired
    MarketSettingApi marketSettingApi;
    @PostMapping("/queryMarketStatus")
    @ApiOperation("营销功能-开关状态查询")
    public Response<List<MarketSettingStroreFrom>> queryMarketStatus( Long storeId){

        return Response.ok(marketSettingApi.queryMarketStatus(storeId));

    }

    @PutMapping("/addCoupon")
    @ApiOperation("优惠卷-增加")
    public Response<Boolean> addCoupon(@Valid  @RequestBody MarketCouponForm couponForm){
        if (marketCouponApi.addOrUpdateCoupon(couponForm)){
            return Response.ok();
        }else {
            return Response.fail();
        }

    }

    @PostMapping ("/senCoupon")
    @ApiOperation("优惠卷-发放")
    public Response<Boolean> senCoupon(@Valid @RequestBody SentCouponForm sentCoupon){
        return Response.ok(marketCouponApi.senCoupon(sentCoupon));
    }

    @PostMapping ("/getCouponList")
    @ApiOperation("优惠卷-列表")
    public Response<IPage<MarketListCouponVo>> getCouponList(@Valid @RequestBody MarketCouponQueryForm queryForm){
        IPage<MarketListCouponVo> couponList = marketCouponApi.getCouponList(queryForm);
        return Response.ok(couponList);
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
