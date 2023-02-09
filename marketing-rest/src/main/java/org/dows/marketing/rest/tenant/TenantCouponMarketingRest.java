package org.dows.marketing.rest.tenant;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.form.MarketNameForm;
import org.dows.marketing.service.MarketNameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "营销-优惠卷")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/marketing/coupon")
public class TenantCouponMarketingRest  implements MybatisCrudRest<MarketNameForm, MarketNameEntity, MarketNameService> {
    private final MarketNameApiService nameApiService;


}
