package org.dows.marketing.api;

import org.dows.marketing.form.MarketQuerySettingFrom;
import org.dows.marketing.form.MarketSettingFrom;
import org.dows.marketing.form.MarketSettingStroreFrom;
import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.vo.MarketQuerySettingVo;
import org.dows.marketing.vo.MarketStoreVo;

import java.util.List;

public interface MarketSettingApi {
    List<MarketStoreVo> getMarketingSettingList(MarketStoreFrom tenantId);

    boolean saveMarketSetting(List<MarketStoreVo> voList);

    boolean storeMarketSetting(MarketSettingFrom storeSettings);

    boolean storeMarketSetting(MarketSettingStroreFrom storeSettings);

    MarketQuerySettingVo queryStoreMarketSetting(MarketQuerySettingFrom querySettingFrom);

    List<MarketSettingStroreFrom> queryMarketStatus(Long storeId);
}
