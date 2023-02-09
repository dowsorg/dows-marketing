package org.dows.marketing.rest.tenant;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.form.MarketNameForm;
import org.dows.marketing.service.MarketNameService;
import org.dows.store.service.StoreTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "营销-门店权限设置")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/marketing/store")
public class TenantStoreMarketingRest implements MybatisCrudRest<MarketNameForm, MarketNameEntity, MarketNameService> {

    private  final StoreTableService storeTableService;


}
