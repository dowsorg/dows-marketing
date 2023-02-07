package org.dows.marketing;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.bo.MarketAddNameBo;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.enums.MarketNameEnums;
import org.dows.marketing.service.MarketNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketNameBiz implements MarketNameApiService {

    private final MarketNameService nameService;


    @Override
    public boolean addMarketName(MarketAddNameBo nameBo) {
        List<Long> storeIds = nameBo.getStoreIds();
        List<MarketNameEntity> list = Lists.newArrayList();
        for (Long storeId : storeIds) {
            MarketNameEntity marketName = new MarketNameEntity();
            marketName.setStoreId(storeId);
            marketName.setEnable(0);
            MarketNameEnums codeEn = nameBo.getCodeEn();
            marketName.setMarketName(codeEn.getName());
            marketName.setMarketCode(codeEn.getCode());
            list.add(marketName);
        }
        return nameService.saveBatch(list);
    }
}
