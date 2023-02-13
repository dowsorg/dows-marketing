package org.dows.marketing.api;

import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.vo.MarketStoreVo;

import java.util.List;

public interface MarketSettingApi {
    List<MarketStoreVo> getMarketingSettingList(MarketStoreFrom tenantId);

    boolean saveMarketSetting(List<MarketStoreVo> voList);
}
