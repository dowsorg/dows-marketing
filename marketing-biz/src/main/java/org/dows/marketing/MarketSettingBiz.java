package org.dows.marketing;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.marketing.api.MarketSettingApi;
import org.dows.marketing.entity.MarketAttrNameEntity;
import org.dows.marketing.enums.MarketSttingEnums;
import org.dows.marketing.enums.MarketNameEnums;
import org.dows.marketing.form.MarketQuerySettingFrom;
import org.dows.marketing.form.MarketSettingFrom;
import org.dows.marketing.form.MarketSettingStroreFrom;
import org.dows.marketing.form.MarketStoreFrom;
import org.dows.marketing.service.MarketAttrNameService;
import org.dows.marketing.vo.MarketQuerySettingVo;
import org.dows.marketing.vo.MarketStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public boolean storeMarketSetting(MarketSettingFrom storeSettings) {
        if (storeSettings.getAttrVal().equals(MarketSttingEnums.MARKET_SETTING_OFF.getCode())){
            QueryWrapper<MarketAttrNameEntity> wrapper = new QueryWrapper();
            wrapper.lambda()
                    .eq(MarketAttrNameEntity::getTenantId, storeSettings.getTenantId())
                    .eq(MarketAttrNameEntity::getAttrName,storeSettings.getAttrName())
                    .in(MarketAttrNameEntity::getFiledTyp,MarketSttingEnums.MARKET_SETTING_OPEN_STORE.getCode(),
                            MarketSttingEnums.MARKET_SETTING_OPEN_TENANT.getCode());
            attrNameService.remove(wrapper);
        }
        MarketAttrNameEntity nameEntity = new MarketAttrNameEntity();
        BeanUtil.copyProperties(storeSettings,nameEntity);
        nameEntity.setFiledTyp(MarketSttingEnums.MARKET_SETTING_OPEN_TENANT.getCode());
        return attrNameService.saveOrUpdate(nameEntity);
    }

    @Override
    public boolean storeMarketSetting(MarketSettingStroreFrom storeSettings) {
        MarketAttrNameEntity nameEntity = new MarketAttrNameEntity();
        BeanUtil.copyProperties(storeSettings,nameEntity);
        nameEntity.setFiledTyp(MarketSttingEnums.MARKET_SETTING_OPEN_STORE.getCode());
        return attrNameService.saveOrUpdate(nameEntity);
    }

    @Override
    public MarketQuerySettingVo queryStoreMarketSetting(MarketQuerySettingFrom querySettingFrom) {

        MarketQuerySettingVo querySettingVo = new MarketQuerySettingVo();
        // todo 获取门店类别

        List<MarketAttrNameEntity> nameEntityList = attrNameService.lambdaQuery()
                .eq(MarketAttrNameEntity::getAttrName, querySettingFrom.getAttrName())
                .eq(MarketAttrNameEntity::getTenantId, querySettingFrom.getTenantId())
                .list();

        if (nameEntityList != null){
            List<MarketSettingStroreFrom> settingStroreFroms = nameEntityList.stream().filter(x ->
                            x.getFiledTyp().equals(MarketSttingEnums.MARKET_SETTING_OPEN_TENANT.getCode()))
                    .map(x -> new MarketSettingStroreFrom(x.getId(), x.getTenantId(), x.getNameId(), x.getAttrName(), x.getAttrVal()))
                    .collect(Collectors.toList());

            if (settingStroreFroms != null && !settingStroreFroms.isEmpty()){
                querySettingVo.setSettingStore(settingStroreFroms.get(0));
            }

            List<MarketSettingStroreFrom> marketSettingStroreFroms = nameEntityList.stream()
                    .filter(x -> x.getFiledTyp().equals(MarketSttingEnums.MARKET_SETTING_OPEN_STORE.getCode()))
                    .map(x -> new MarketSettingStroreFrom(x.getId(), x.getTenantId(), x.getNameId(), x.getAttrName(), x.getAttrVal()))
                    .collect(Collectors.toList());

            querySettingVo.setAllStoreSetting(marketSettingStroreFroms);
        }
        return querySettingVo;
    }

    @Override
    public List<MarketSettingStroreFrom> queryMarketStatus(Long storeId) {
        List<MarketSettingStroreFrom> settingStroreFroms = attrNameService.lambdaQuery()
                .eq(MarketAttrNameEntity::getFiledTyp, MarketSttingEnums.MARKET_SETTING_OPEN_STORE.getCode())
                .eq(MarketAttrNameEntity::getNameId, storeId)
                .list().stream()
                .map(x -> new MarketSettingStroreFrom(x.getId(), x.getTenantId(), x.getNameId(), x.getAttrName(), x.getAttrVal()))
                .collect(Collectors.toList());

        return settingStroreFroms;
    }
}
