package org.dows.marketing.rest.tenant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.api.MarketSettingApi;
import org.dows.marketing.form.MarketStoreAuthForm;
import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.vo.MarketStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "营销-门店权限设置")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/marketing/store")
public class TenantStoreMarketingRest {

    @Autowired
    MarketSettingApi marketSettingApi;


    @PostMapping("/getMarketingSettingList")
    @ApiOperation("【总部】营销权限-门店营销权限")
    public Response<List<MarketStoreVo>> getMarketingSettingList(@Valid @RequestBody MarketStoreFrom marketStoreFrom){
        List<MarketStoreVo>  marketStoreVoList = marketSettingApi.getMarketingSettingList(marketStoreFrom);
        return Response.ok(marketStoreVoList);
    }


    @PutMapping("/saveMarketSetting")
    @ApiOperation("【总部】营销权限-门店营销权限-编辑、保存")
    public Response<List<MarketStoreVo>> saveMarketSetting(@Valid @RequestBody List<MarketStoreVo> voList){

         if (marketSettingApi.saveMarketSetting(voList)){
             return Response.ok();
         }else {
             return Response.fail();
         }

    }

}
