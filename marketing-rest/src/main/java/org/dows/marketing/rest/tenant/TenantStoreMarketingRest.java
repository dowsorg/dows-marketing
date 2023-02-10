package org.dows.marketing.rest.tenant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.marketing.form.MarketStoreAuthForm;
import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.vo.MarketStoreVo;
import org.dows.store.service.StoreTableService;
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
    private  final StoreTableService storeTableService;


    @GetMapping("/getStoreMarketingList")
    @ApiOperation("门店营销权限-列表")
    public Response<List<MarketStoreVo>> addMarketCardName(@Valid @RequestBody MarketStoreFrom marketStoreFrom){
        List<MarketStoreVo>  marketStoreVoList = new ArrayList<>();

        return Response.ok(marketStoreVoList);
    }


    @PutMapping("/saveStoreMarketing")
    @ApiOperation("门店营销权限-保存")
    public Response<List<MarketStoreVo>> addMarketCardName(@Valid @RequestBody MarketStoreAuthForm authFrom){

        List<MarketStoreVo>  marketStoreVoList = new ArrayList<>();

        return Response.ok(marketStoreVoList);
    }

}
