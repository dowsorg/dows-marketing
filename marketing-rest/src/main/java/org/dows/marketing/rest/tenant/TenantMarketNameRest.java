package org.dows.marketing.rest.tenant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.bo.MarketIntegralAttValBo;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.form.*;
import org.dows.marketing.service.MarketNameService;
import org.dows.marketing.vo.MarketCardAttrValVo;
import org.dows.marketing.vo.MarketIntegralAttrValVo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
@RequestMapping("tenant/marketing")
public class TenantMarketNameRest implements MybatisCrudRest<MarketNameForm, MarketNameEntity, MarketNameService> {


    private final MarketNameApiService nameApiService;

    /**
     * 门店充值套餐(储蓄卡)
     * @param cardNameForm
     * @return
     */
    @PostMapping("/addMarketCardName")
    @ApiOperation("门店充值套餐(储蓄卡)")
    public Response<Boolean> addMarketCardName(@Valid @RequestBody MarketCardNameForm cardNameForm){
        nameApiService.addMarketCardName(cardNameForm);
        return Response.ok();
    }

    /**
     * 获取门店充值套餐(储蓄卡)
     * @param nameForm
     * @return
     */
    @PostMapping("/getMarketNameCard")
    @ApiOperation("获取门店充值套餐(储蓄卡)")
    public Response<List<MarketCardAttrValVo>> getMarketNameCard(@Valid @RequestBody MarketQueryNameForm nameForm){
        return Response.ok(nameApiService.getMarketCardName(nameForm));
    }

    /**
     * 删除门店充值套餐(储蓄卡)
     * @param marketNameId
     * @return
     */
    @PostMapping("/removeMarketName")
    @ApiOperation("删除门店充值套餐")
    public Response<Boolean> removeMarketCardName(@RequestParam("marketNameId") String marketNameId){
        return Response.ok(nameApiService.removeMarketCardName(marketNameId));
    }


    /**
     * 门店充值套餐(积分)
     * @param integralNameForm
     * @return
     */
    @PostMapping("/addMarketIntegralName")
    @ApiOperation("门店充值套餐(积分)")
    public Response<Boolean> addMarketIntegralName(@Valid @RequestBody MarketIntegralNameForm integralNameForm){
        nameApiService.addMarketIntegral(integralNameForm);
        return Response.ok();
    }

    /**
     * 获取门店充值套餐(积分)
     * @param nameForm
     * @return
     */
    @PostMapping("/getMarketNameIntegral")
    @ApiOperation("获取门店充值套餐(积分)")
    public Response<List<MarketIntegralAttrValVo>> getMarketNameIntegral(@Valid @RequestBody MarketQueryNameForm nameForm){
        return Response.ok(nameApiService.getIntegralName(nameForm));
    }






}

