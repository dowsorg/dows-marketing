package org.dows.marketing.rest.tenant;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.form.*;
import org.dows.marketing.vo.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class TenantMarketNameRest {


    private final MarketNameApiService nameApiService;

    /**
     * 新增或编辑门店充值套餐(储蓄卡)
     * @param cardNameForm
     * @return
     */
    @PostMapping("/addMarketCardName")
    @ApiOperation("新增或编辑门店充值套餐(储蓄卡)")
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
     * @param idForm
     * @return
     */
    @PostMapping("/removeMarketName")
    @ApiOperation("删除门店充值套餐")
    public Response<Boolean> removeMarketCardName(@Valid @RequestBody MarketIdForm idForm){
        return Response.ok(nameApiService.removeMarketCardName(idForm.getMarketNameId()));
    }


    /**
     * 新增或编辑门店充值套餐(积分)
     * @param integralNameForm
     * @return
     */
    @PostMapping("/addMarketIntegralName")
    @ApiOperation("新增或编辑门店充值套餐(积分)")
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


    /**
     * 储蓄卡列表(pc)
     * @param queryForm
     * @return
     */
    @PostMapping("/getMarketCardPageList")
    @ApiOperation("储蓄卡列表(pc)")
    public Response<Page<MarketCardListVo>> getMarketCardPageList(@RequestBody MarketCardListQueryForm queryForm){
        Page<MarketCardListVo> page = new Page<>();
        return Response.ok(page);
    }

    /**
     * 储蓄卡充值列表(pc)
     * @param queryForm
     * @return
     */
    @PostMapping("/getMarketCardRechargePageList")
    @ApiOperation("储蓄卡充值列表(pc)")
    public Response<Page<MarketCardRechargeListVo>> getMarketCardRechargePageList(@RequestBody MarketCardListQueryForm queryForm){
        Page<MarketCardRechargeListVo> page = new Page<>();
        return Response.ok(page);
    }


    /**
     * 储蓄卡使用列表(pc)
     * @param queryForm
     * @return
     */
    @PostMapping("/getMarketCardUsePageList")
    @ApiOperation("储蓄卡使用列表(pc)")
    public Response<Page<MarketCardUseListVo>> getMarketCardUsePageList(@RequestBody MarketCardListQueryForm queryForm){
        Page<MarketCardUseListVo> page = new Page<>();
        return Response.ok(page);
    }







}

