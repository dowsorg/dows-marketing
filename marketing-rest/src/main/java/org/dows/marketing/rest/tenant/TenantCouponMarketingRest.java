package org.dows.marketing.rest.tenant;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.api.MarketCouponApi;
import org.dows.marketing.form.*;
import org.dows.marketing.service.MarketCategoryService;
import org.dows.marketing.vo.MarkerCouponRecordVo;
import org.dows.marketing.vo.MarkerSendCouponVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "【总部】营销-优惠卷")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/marketing/coupon")
public class TenantCouponMarketingRest   {

    private final MarketCategoryService marketCategoryService;

    @Autowired
    MarketCouponApi marketCouponApi;

    @PutMapping("/addCoupon")
    @ApiOperation("优惠卷-增加")
    public Response<Boolean> addCoupon(@Valid  @RequestBody
                                           MarketCouponForm couponForm){
        if (marketCouponApi.addOrUpdateCoupon(couponForm)){
            return Response.ok();
        }else {
            return Response.fail();
        }

    }

    @PostMapping ("/getCouponList")
    @ApiOperation("优惠卷-列表")
    public Response<IPage<MarketListCouponVo>> getCouponList(@Valid @RequestBody
                                                                 MarketCouponQueryForm queryForm){
        IPage<MarketListCouponVo> couponList = marketCouponApi.getCouponList(queryForm);
        return Response.ok(couponList);
    }

    @GetMapping ("/getCouponRecordList")
    @ApiOperation("优惠卷-领取记录列表")
    public Response<IPage<MarkerCouponRecordVo>> getCouponRecordList(@Valid @RequestBody
                                            MarketProvideGiveQuery marketProvideGiveQuery){
        IPage<MarkerCouponRecordVo>  iPage = marketCouponApi.provideGiveList(marketProvideGiveQuery);

        return Response.ok(iPage);
    }

    @GetMapping ("/sendCouponList")
    @ApiOperation("优惠卷-发放记录列表")
    public Response<IPage<MarkerSendCouponVo>> sendCouponList(@Valid @RequestBody
                                                                MarketSendCouponQuery marketSendCouponQuery ){
        IPage<MarkerSendCouponVo>  iPage = marketCouponApi.sendCouponList(marketSendCouponQuery);

        return Response.ok(iPage);
    }


}
