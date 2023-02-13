package org.dows.marketing;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.marketing.api.MarketSettingApi;
import org.dows.marketing.entity.MarketAttrNameEntity;
import org.dows.marketing.enums.MarketSttingEnums;
import org.dows.marketing.enums.MarketNameEnums;
import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.service.MarketAttrNameService;
import org.dows.marketing.vo.MarketStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketSettingBiz implements MarketSettingApi {


    @Autowired
    MarketAttrNameService attrNameService;


    @Override
    public List<MarketStoreVo> getMarketingSettingList(MarketStoreFrom marketStoreFrom) {
        List<MarketAttrNameEntity> list = attrNameService.lambdaQuery()
                .eq(MarketAttrNameEntity::getFiledTyp, MarketSttingEnums.MARKET_SETTING_TENANT.getCode())

                // todo 这个里的tenantid 后期安全考虑要后端 自行获取

                .eq(MarketAttrNameEntity::getTenantId, marketStoreFrom.getTenantId())
                .list();

        Map<String, MarketAttrNameEntity> attrNameEntityHashMap = new HashMap<>();

        if (list != null && !list.isEmpty()){
            attrNameEntityHashMap = list.stream()
                    .collect(Collectors.toMap(MarketAttrNameEntity::getAttrName, Function.identity()));
        }

        Map<String, MarketAttrNameEntity> finalAttrNameEntityHashMap = attrNameEntityHashMap;
        List<MarketStoreVo> marketStoreVos = Arrays.stream(MarketNameEnums.values()).map(
                x -> {
                    MarketStoreVo vo = new MarketStoreVo();
                    vo.setCategoryName(x.getName());
                    String marketType = Integer.toString(x.getCode());
                    vo.setAttrName(marketType);
                    vo.setTenantId(marketStoreFrom.getTenantId());

                    if (finalAttrNameEntityHashMap == null || finalAttrNameEntityHashMap.get(marketType) == null) {
                        vo.setAttrVal(MarketSttingEnums.MARKET_SETTING_OFF.getCode());
                    } else {
                        // 存在
                        vo.setAttrVal(finalAttrNameEntityHashMap.get(marketType).getAttrVal());
                        vo.setId(finalAttrNameEntityHashMap.get(marketType).getId());
                    }

                    return vo;
                }
        ).collect(Collectors.toList());

        return marketStoreVos;
    }

    @Override
    public boolean saveMarketSetting(List<MarketStoreVo> voList) {
        // todo 这个里的tenantid 后期安全考虑要后端 自行获取
        List<MarketAttrNameEntity> collect = voList.stream().map(x -> new MarketAttrNameEntity(x.getAttrName()
                        ,x.getAttrVal(),x.getNameId(),x.getTenantId(),x.getId()))
                .map(x -> x.setFiledTyp(MarketSttingEnums.MARKET_SETTING_TENANT.getCode()))
                .collect(Collectors.toList());
        return  attrNameService.saveOrUpdateBatch(collect);
    }
}
