package org.dows.marketing;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.dows.marketing.api.MarketNameApiService;
import org.dows.marketing.bo.MarketCardAttrValBo;
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

import java.util.Arrays;
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


    @Override
    @Transactional
    public void addMarketCardName(MarketCardNameForm nameForm) {
        DateTime date = DateUtil.date();
        if(StrUtil.isBlank(nameForm.getMarketNameId())){//新增
            MarketCategoryEntity categoryEntity = categoryService.lambdaQuery()
                    .eq(MarketCategoryEntity::getCategoryCode, nameForm.getCodeEn().getCode()).one();
            for (Long storeId : nameForm.getStoreIds()) {
                MarketNameEntity nameEntity = new MarketNameEntity();
                nameEntity.setCategoryId(categoryEntity.getId());
                String idStr = IdWorker.getIdStr();
                nameEntity.setMarketNameId(idStr);
                nameEntity.setStoreId(storeId);
                nameEntity.setCategoryName(categoryEntity.getCategoryName());
                nameEntity.setDt(date);
                List<String> format = processAttrCard(nameForm, date, idStr);
                nameEntity.setMarketName(String.format("充值%s到账%s",format.toArray()));
                nameService.save(nameEntity);
            }
        }else {
            deleteAttrVal(nameForm.getMarketNameId());
            List<String> format = processAttrCard(nameForm, date, nameForm.getMarketNameId());
            nameService.lambdaUpdate()
                    .set(MarketNameEntity::getMarketName,String.format("充值%s到账%s",format.toArray()))
                    .eq(MarketNameEntity::getMarketNameId,nameForm.getMarketNameId()).update();
        }
    }

    private List<String> processAttrCard(MarketCardNameForm nameForm, DateTime date, String marketNameId) {
        List<String> format = Lists.newArrayList();
        Map<String, String> marketAttrCard = MarketNameEnums.getMarketAttrCard(nameForm.getCardAttValBo());
        for (Map.Entry<String, String> entry : marketAttrCard.entrySet()) {
            MarketAttrNameEntity attrNameEntity = new MarketAttrNameEntity();
            attrNameEntity.setMarketNameId(marketNameId);
            attrNameEntity.setAttrName(entry.getKey());
            attrNameEntity.setFiledName(entry.getKey());
            attrNameEntity.setDt(date);
            attrNameService.save(attrNameEntity);
            MarketAttrValEntity valEntity = new MarketAttrValEntity();
            valEntity.setAttrVal(entry.getValue());
            if (!Arrays.asList("startTime", "endTime").contains(entry.getKey())) {
                format.add(entry.getValue());
            }
            valEntity.setAttrNameId(attrNameEntity.getId());
            valEntity.setDt(date);
            attrValService.save(valEntity);
        }
        return format;
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
            List<MarketAttrNameEntity> attrNameEntityList = attrNameService.lambdaQuery().in(MarketAttrNameEntity::getMarketNameId, marketNameIds).list();
            Map<String, List<MarketAttrNameEntity>> attrNameMap = CollStreamUtil.groupBy(attrNameEntityList, MarketAttrNameEntity::getMarketNameId, Collectors.toList());

            List<Long> attrNameIds = attrNameEntityList.stream().map(MarketAttrNameEntity::getId).collect(Collectors.toList());
            List<MarketAttrValEntity> attrValList = attrValService.lambdaQuery().in(MarketAttrValEntity::getAttrNameId, attrNameIds).list();
            Map<Long, String> attrValMap = CollStreamUtil.toMap(attrValList, MarketAttrValEntity::getAttrNameId, MarketAttrValEntity::getAttrVal);
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
                    cardAttrValVo.setCardAttrValBo(JSONUtil.toBean(jsonObject, MarketCardAttrValBo.class));
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
        deleteAttrVal(marketNameId);
        return nameService.removeById(nameEntity.getId());

    }

    /**
     * 删除属性和对于的val
     * @param marketNameId
     */
    private void deleteAttrVal(String marketNameId){
        List<MarketAttrNameEntity> attrNameEntityList = attrNameService.lambdaQuery().eq(MarketAttrNameEntity::getMarketNameId, marketNameId).list();
        Set<Long> attrNameIds = attrNameEntityList.stream().map(MarketAttrNameEntity::getId).collect(Collectors.toSet());
        attrNameService.removeByIds(attrNameIds);
        List<MarketAttrValEntity> attrValList = attrValService.lambdaQuery().in(MarketAttrValEntity::getAttrNameId, attrNameIds).list();
        Set<Long> attrValIds = attrValList.stream().map(MarketAttrValEntity::getId).collect(Collectors.toSet());
        attrValService.removeByIds(attrValIds);
    }

    @SneakyThrows
    @Override
    public void addMarketIntegral(MarketIntegralNameForm integralNameForm) {
        DateTime date = DateUtil.date();
        if(StrUtil.isBlank(integralNameForm.getMarketNameId())){//新增
            MarketCategoryEntity categoryEntity = categoryService.lambdaQuery()
                    .eq(MarketCategoryEntity::getCategoryCode, integralNameForm.getCodeEn().getCode()).one();
            for (Long storeId : integralNameForm.getStoreIds()) {
                MarketNameEntity nameEntity = new MarketNameEntity();
                nameEntity.setCategoryId(categoryEntity.getId());
                String idStr = IdWorker.getIdStr();
                nameEntity.setMarketNameId(idStr);
                nameEntity.setStoreId(storeId);
                nameEntity.setCategoryName(categoryEntity.getCategoryName());
                nameEntity.setType(integralNameForm.getIntegralAttValBo().getType());
                nameEntity.setDt(date);
                List<String> format = processAttrIntegral(integralNameForm, date, idStr);
                if(Integer.valueOf(1).equals(integralNameForm.getIntegralAttValBo().getType())){
                    nameEntity.setMarketName(String.format("%s积分=¥%s",format.toArray()));
                }
                if(Integer.valueOf(2).equals(integralNameForm.getIntegralAttValBo().getType())){
                    nameEntity.setMarketName(String.format("消费每达%s元返%s积分",format.toArray()));
                }
                nameService.save(nameEntity);
            }
        }else{
            deleteAttrVal(integralNameForm.getMarketNameId());
            List<String> format = processAttrIntegral(integralNameForm, date, integralNameForm.getMarketNameId());
            nameService.lambdaUpdate()
                    .set(Integer.valueOf(1).equals(integralNameForm.getIntegralAttValBo().getType()),MarketNameEntity::getMarketName,String.format("%s积分=¥%s",format.toArray()))
                    .set(Integer.valueOf(2).equals(integralNameForm.getIntegralAttValBo().getType()),MarketNameEntity::getMarketName,String.format("消费每达%s元返%s积分",format.toArray()))
                    .eq(MarketNameEntity::getMarketNameId,integralNameForm.getMarketNameId()).update();
        }
    }

    @Override
    public <T> T getMarketCardAttrVal(String marketNameId,Class<T> tClass) {
        List<MarketAttrNameEntity> attrNameList = attrNameService.lambdaQuery().eq(MarketAttrNameEntity::getMarketNameId, marketNameId).list();
        if(!CollUtil.isEmpty(attrNameList)){
            JSONObject object = new JSONObject();
            List<MarketAttrValEntity> attrValList = attrValService.lambdaQuery().in(MarketAttrValEntity::getAttrNameId, CollStreamUtil.toList(attrNameList, MarketAttrNameEntity::getId)).list();
            Map<Long, String> attrValMap = CollStreamUtil.toMap(attrValList, MarketAttrValEntity::getAttrNameId, MarketAttrValEntity::getAttrVal);
            for (MarketAttrNameEntity attrNameEntity : attrNameList) {
                object.set(attrNameEntity.getAttrName(),attrValMap.get(attrNameEntity.getId()));
            }
            return JSONUtil.toBean(object,tClass);
        }
        return null;
    }

    private List<String> processAttrIntegral(MarketIntegralNameForm integralNameForm, DateTime date, String marketNameId) {
        MarketIntegralAttValBo attValBo = integralNameForm.getIntegralAttValBo();
        Map<String, String> marketAttrCard = Maps.newHashMap();
        if (Integer.valueOf(1).equals(integralNameForm.getIntegralAttValBo().getType())) {
            marketAttrCard = MarketNameEnums.getMarketAttrCard(attValBo.getIntegeral());
        }
        if (Integer.valueOf(2).equals(integralNameForm.getIntegralAttValBo().getType())) {
            marketAttrCard = MarketNameEnums.getMarketAttrCard(attValBo.getReturnIntegeral());
        }
        List<String> format = Lists.newArrayList();
        for (Map.Entry<String, String> entry : marketAttrCard.entrySet()) {
            MarketAttrNameEntity attrNameEntity = new MarketAttrNameEntity();
            attrNameEntity.setMarketNameId(marketNameId);
            attrNameEntity.setAttrName(entry.getKey());
            attrNameEntity.setFiledName(entry.getKey());
            attrNameEntity.setDt(date);
            attrNameService.save(attrNameEntity);
            MarketAttrValEntity valEntity = new MarketAttrValEntity();
            valEntity.setAttrVal(entry.getValue());
            format.add(entry.getValue());
            valEntity.setAttrNameId(attrNameEntity.getId());
            valEntity.setDt(date);
            attrValService.save(valEntity);
        }
        return format;
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
            List<MarketAttrNameEntity> attrNameEntityList = attrNameService.lambdaQuery().in(MarketAttrNameEntity::getMarketNameId, marketNameIds).list();
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
