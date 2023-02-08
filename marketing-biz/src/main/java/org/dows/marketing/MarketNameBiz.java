package org.dows.marketing;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.bo.MarketIntegralAttValBo;
import org.dows.marketing.entity.MarketAttrNameEntity;
import org.dows.marketing.entity.MarketAttrValEntity;
import org.dows.marketing.entity.MarketCategoryEntity;
import org.dows.marketing.entity.MarketNameEntity;
import org.dows.marketing.enums.MarketNameEnums;
import org.dows.marketing.form.MarketCardNameForm;
import org.dows.marketing.form.MarketIntegralNameForm;
import org.dows.marketing.form.MarketQueryNameForm;
import org.dows.marketing.service.MarketAttrNameService;
import org.dows.marketing.service.MarketAttrValService;
import org.dows.marketing.service.MarketCategoryService;
import org.dows.marketing.service.MarketNameService;
import org.dows.marketing.vo.MarketCardAttrValVo;
import org.dows.marketing.vo.MarketIntegralAttrValVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketNameBiz implements MarketNameApiService {

    private final MarketNameService nameService;

    private final MarketAttrNameService attrNameService;

    private final MarketAttrValService attrValService;

    private final MarketCategoryService categoryService;


    @SneakyThrows
    @Override
    @Transactional
    public void addMarketCardName(MarketCardNameForm nameForm) {
        MarketCategoryEntity categoryEntity = categoryService.lambdaQuery()
                .eq(MarketCategoryEntity::getCategoryCode, nameForm.getCodeEn().getCode()).one();
        DateTime date = DateUtil.date();
        for (Long storeId : nameForm.getStoreIds()) {
            MarketNameEntity nameEntity = new MarketNameEntity();
            nameEntity.setCategoryId(categoryEntity.getId());
            String idStr = IdWorker.getIdStr();
            nameEntity.setMarketNameId(idStr);
            nameEntity.setStoreId(storeId);
            nameEntity.setCategoryName(categoryEntity.getCategoryName());
            nameEntity.setMarketName(nameForm.getCardAttValBo().getName());
            nameEntity.setDt(date);
            nameService.save(nameEntity);
            Map<String, String> cardAttrValMap = MarketNameEnums.getCardAttrVal(nameForm.getCardAttValBo());
            String[] cardAttrName = MarketNameEnums.cardAttrName;
            for (String nameAtt : cardAttrName) {
                MarketAttrNameEntity attrNameEntity = new MarketAttrNameEntity();
                attrNameEntity.setMarketNameId(idStr);
                attrNameEntity.setAttrName(nameAtt);
                attrNameEntity.setFiledName(nameAtt);
                attrNameEntity.setDt(date);
                attrNameService.save(attrNameEntity);
                MarketAttrValEntity valEntity = new MarketAttrValEntity();
                valEntity.setAttrVal(cardAttrValMap.get(nameAtt));
                valEntity.setAttrNameId(attrNameEntity.getId());
                valEntity.setDt(date);
                attrValService.save(valEntity);
            }
        }
    }

    @Override
    public List<MarketCardAttrValVo> getMarketCardName(MarketQueryNameForm nameForm) {
        List<MarketCardAttrValVo> attrValVos = Lists.newArrayList();
        MarketCategoryEntity categoryEntity = categoryService.lambdaQuery()
                .eq(MarketCategoryEntity::getCategoryCode, nameForm.getCodeEn().getCode()).one();
        List<MarketNameEntity> nameEntityList = nameService.lambdaQuery()
                .eq(MarketNameEntity::getStoreId, nameForm.getStoreId())
                .eq(MarketNameEntity::getCategoryId, categoryEntity.getId()).list();
        if(!CollUtil.isEmpty(nameEntityList)){
            List<String> marketNameIds = nameEntityList.stream().map(MarketNameEntity::getMarketNameId).collect(Collectors.toList());
            List<MarketAttrNameEntity> attrNameEntityList = attrNameService.lambdaQuery().eq(MarketAttrNameEntity::getMarketNameId, marketNameIds).list();
            List<Long> attrNameIds = attrNameEntityList.stream().map(MarketAttrNameEntity::getId).collect(Collectors.toList());
            List<MarketAttrValEntity> attrValList = attrValService.lambdaQuery().in(MarketAttrValEntity::getAttrNameId, attrNameIds).list();
            Map<Long, String> attrValMap = CollStreamUtil.toMap(attrValList, MarketAttrValEntity::getAttrNameId, MarketAttrValEntity::getAttrVal);
            Map<String, List<MarketAttrNameEntity>> attrNameMap = CollStreamUtil.groupBy(attrNameEntityList, MarketAttrNameEntity::getMarketNameId, Collectors.toList());
            for (MarketNameEntity nameEntity : nameEntityList) {
                MarketCardAttrValVo cardAttrValVo = new MarketCardAttrValVo();
                cardAttrValVo.setMarketNameId(nameEntity.getMarketNameId());
                cardAttrValVo.setName(nameEntity.getMarketName());
                if(attrNameMap.containsKey(nameEntity.getMarketNameId())){
                    Map<Long, String> attrIdNameMap = CollStreamUtil.toMap(attrNameMap.get(nameEntity.getMarketNameId()), MarketAttrNameEntity::getId, MarketAttrNameEntity::getAttrName);
                    JSONObject jsonObject = new JSONObject();
                    for (Map.Entry<Long, String> entry : attrIdNameMap.entrySet()) {
                        String attrName = entry.getValue();
                        String val = attrValMap.get(entry.getKey());
                        jsonObject.set(attrName,val);
                    }
                    cardAttrValVo.setCardAttrVal(JSONUtil.toBean(jsonObject,MarketCardAttrValVo.CardAttrVal.class));
                }
                attrValVos.add(cardAttrValVo);
            }
        }
        return attrValVos;
    }

    @Override
    @Transactional
    public boolean removeMarketCardName(String marketNameId) {
        MarketNameEntity nameEntity = nameService.lambdaQuery().eq(MarketNameEntity::getMarketNameId, marketNameId).one();
        nameService.removeById(nameEntity.getId());
        List<MarketAttrNameEntity> attrNameEntityList = attrNameService.lambdaQuery().eq(MarketAttrNameEntity::getMarketNameId, marketNameId).list();
        Set<Long> attrNameIds = attrNameEntityList.stream().map(MarketAttrNameEntity::getId).collect(Collectors.toSet());
        attrNameService.removeByIds(attrNameIds);
        List<MarketAttrValEntity> attrValList = attrValService.lambdaQuery().in(MarketAttrValEntity::getAttrNameId, attrNameIds).list();
        Set<Long> attrValIds = attrValList.stream().map(MarketAttrValEntity::getId).collect(Collectors.toSet());
        return attrValService.removeByIds(attrValIds);
    }

    @SneakyThrows
    @Override
    public void addMarketIntegral(MarketIntegralNameForm integralNameForm) {
        MarketCategoryEntity categoryEntity = categoryService.lambdaQuery()
                .eq(MarketCategoryEntity::getCategoryCode, integralNameForm.getCodeEn().getCode()).one();
        DateTime date = DateUtil.date();
        for (Long storeId : integralNameForm.getStoreIds()) {
            MarketNameEntity nameEntity = new MarketNameEntity();
            nameEntity.setCategoryId(categoryEntity.getId());
            String idStr = IdWorker.getIdStr();
            nameEntity.setMarketNameId(idStr);
            nameEntity.setStoreId(storeId);
            nameEntity.setCategoryName(categoryEntity.getCategoryName());
            nameEntity.setMarketName(integralNameForm.getIntegralAttValBo().getName());
            nameEntity.setType(integralNameForm.getIntegralAttValBo().getType());
            nameEntity.setDt(date);
            nameService.save(nameEntity);
            MarketIntegralAttValBo attValBo = integralNameForm.getIntegralAttValBo();
            String[] integralAttrName = new String[]{};
            Map<String, String> integralAttrValMap = Maps.newHashMap();
            if(Integer.valueOf(1).equals(integralNameForm.getIntegralAttValBo().getType())){
                integralAttrName = MarketNameEnums.integralAttrName;
                integralAttrValMap = MarketNameEnums.getIntegralAttrVal(attValBo.getIntegeral());
            }
            if(Integer.valueOf(2).equals(integralNameForm.getIntegralAttValBo().getType())){
                integralAttrName = MarketNameEnums.returnIntegralAttrName;
                integralAttrValMap = MarketNameEnums.getReturnIntegralAttrNameAttrVal(attValBo.getReturnIntegeral());
            }
            for (String attrName : integralAttrName) {
                MarketAttrNameEntity attrNameEntity = new MarketAttrNameEntity();
                attrNameEntity.setMarketNameId(idStr);
                attrNameEntity.setAttrName(attrName);
                attrNameEntity.setFiledName(attrName);
                attrNameEntity.setDt(date);
                attrNameService.save(attrNameEntity);
                MarketAttrValEntity valEntity = new MarketAttrValEntity();
                valEntity.setAttrVal(integralAttrValMap.get(attrName));
                valEntity.setAttrNameId(attrNameEntity.getId());
                valEntity.setDt(date);
                attrValService.save(valEntity);
            }
        }
    }

    @Override
    public List<MarketIntegralAttrValVo> getIntegralName(MarketQueryNameForm nameForm) {
        List<MarketIntegralAttrValVo> attrValVos = Lists.newArrayList();
        MarketCategoryEntity categoryEntity = categoryService.lambdaQuery()
                .eq(MarketCategoryEntity::getCategoryCode, nameForm.getCodeEn().getCode()).one();
        List<MarketNameEntity> nameEntityList = nameService.lambdaQuery()
                .eq(MarketNameEntity::getStoreId, nameForm.getStoreId())
                .eq(MarketNameEntity::getCategoryId, categoryEntity.getId()).list();
        if(!CollUtil.isEmpty(nameEntityList)){
            List<String> marketNameIds = nameEntityList.stream().map(MarketNameEntity::getMarketNameId).collect(Collectors.toList());
            List<MarketAttrNameEntity> attrNameEntityList = attrNameService.lambdaQuery().eq(MarketAttrNameEntity::getMarketNameId, marketNameIds).list();
            List<Long> attrNameIds = attrNameEntityList.stream().map(MarketAttrNameEntity::getId).collect(Collectors.toList());
            List<MarketAttrValEntity> attrValList = attrValService.lambdaQuery().in(MarketAttrValEntity::getAttrNameId, attrNameIds).list();
            Map<Long, String> attrValMap = CollStreamUtil.toMap(attrValList, MarketAttrValEntity::getAttrNameId, MarketAttrValEntity::getAttrVal);
            Map<String, List<MarketAttrNameEntity>> attrNameMap = CollStreamUtil.groupBy(attrNameEntityList, MarketAttrNameEntity::getMarketNameId, Collectors.toList());
            for (MarketNameEntity nameEntity : nameEntityList) {
                MarketIntegralAttrValVo integralAttrValVo = new MarketIntegralAttrValVo();
                integralAttrValVo.setMarketNameId(nameEntity.getMarketNameId());
                integralAttrValVo.setType(nameEntity.getType());
                integralAttrValVo.setName(nameEntity.getMarketName());
                if(attrNameMap.containsKey(nameEntity.getMarketNameId())){
                    Map<Long, String> attrIdNameMap = CollStreamUtil.toMap(attrNameMap.get(nameEntity.getMarketNameId()), MarketAttrNameEntity::getId, MarketAttrNameEntity::getAttrName);
                    JSONObject jsonObject = new JSONObject();
                    for (Map.Entry<Long, String> entry : attrIdNameMap.entrySet()) {
                        String attrName = entry.getValue();
                        String val = attrValMap.get(entry.getKey());
                        jsonObject.set(attrName,val);
                    }
                    if(Integer.valueOf(1).equals(integralAttrValVo.getType())){
                        integralAttrValVo.setIntegeral(JSONUtil.toBean(jsonObject,MarketIntegralAttrValVo.Integeral.class));
                    }
                    if(Integer.valueOf(2).equals(integralAttrValVo.getType())){
                        integralAttrValVo.setReturnIntegeral(JSONUtil.toBean(jsonObject,MarketIntegralAttrValVo.ReturnIntegeral.class));
                    }
                }
                attrValVos.add(integralAttrValVo);
            }
        }
        return attrValVos;
    }
}
