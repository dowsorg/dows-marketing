package org.dows.marketing;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.marketing.api.MarketCouponApi;
import org.dows.marketing.entity.MarketActorEntity;
import org.dows.marketing.entity.MarketActorRecordEntity;
import org.dows.marketing.entity.MarketCouponEntity;
import org.dows.marketing.entity.MarketCouponStoreEntity;
import org.dows.marketing.enums.MarketConstantEnums;
import org.dows.marketing.form.*;
import org.dows.marketing.mapper.MarketCouponMapperJoin;
import org.dows.marketing.service.*;
import org.dows.marketing.vo.MarkerCouponRecordVo;
import org.dows.marketing.vo.MarkerSendCouponVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketCouponBiz implements MarketCouponApi  {


    @Autowired
    MarketCouponService couponService;

    @Autowired
    MarketNameService nameService;

    @Autowired
    MarketCouponMapperJoin couponMapper;

    @Autowired
    MarketCouponStoreService couponStoreService;

    @Autowired
    MarketActorService actorService;

    @Autowired
    MarketActorRecordService actorRecordService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addOrUpdateCoupon(MarketCouponForm couponForm) {

        MarketCouponEntity couponEntity = new MarketCouponEntity();
            if (couponForm.getId() != null){
                QueryWrapper<MarketCouponStoreEntity> wrapper = new QueryWrapper<MarketCouponStoreEntity>();
                wrapper.lambda().eq(MarketCouponStoreEntity::getCouponId,couponForm.getId());
                couponStoreService.remove(wrapper);
            }else {
                couponForm.setId(IdWorker.getId());
            }

            BeanUtil.copyProperties(couponForm,couponEntity);
            //todo 后期需要修改为实时租户id
            String tenantId = "1";
            couponEntity.setTenantId(tenantId);
            couponService.saveOrUpdate(couponEntity);

            List<MarketCouponStoreEntity> marketCouponStoreEntities = couponForm.getStoreIds().stream().map(
                    x -> new MarketCouponStoreEntity()
                            .setStoreId(x)
                            .setCouponId(couponEntity.getId())
                            .setTenantId(tenantId)
            ).collect(Collectors.toList());

            return couponStoreService.saveOrUpdateBatch(marketCouponStoreEntities);
    }

    @Override
    @Transactional
    public Boolean senCoupon(SentCouponForm sentCoupon) {

        //发放记录
        List<MarketActorEntity> marketActorEntities = sentCoupon.getUserIds().stream().map(x -> {
            MarketActorEntity actorEntity = new MarketActorEntity();
            actorEntity.setAccountId(x);
            actorEntity.setMarketId(sentCoupon.getCouponId());
            return actorEntity;
        }).collect(Collectors.toList());

        MarketCouponEntity couponEntity = couponService.getById(sentCoupon.getCouponId());

        if (couponEntity == null){
            return false;
        }

        //领取记录
        List<MarketActorRecordEntity> marketActorRecordEntityList  = marketActorEntities.stream().map(
               x-> {
                  if (MarketConstantEnums.LQ_ZDLQ.getCode().equals(couponEntity.getReceiveMethod())){
                       MarketActorRecordEntity marketActorRecord = new MarketActorRecordEntity();
                       marketActorRecord.setRuleJson(MarketConstantEnums.LQ_ZDLQ.getCode());
                       marketActorRecord.setDt(new Date());
                       marketActorRecord.setMarketId(x.getMarketId());
                       marketActorRecord.setAccountId(x.getAccountId());
                       return marketActorRecord;
                   }
                  return null;
               }
        ).filter(x -> x != null).collect(Collectors.toList());


        actorRecordService.saveOrUpdateBatch(marketActorRecordEntityList);
        return actorService.saveOrUpdateBatch(marketActorEntities);
    }

    @Override
    public IPage getCouponList(MarketCouponQueryForm queryForm) {

        MPJLambdaWrapper<MarketCouponEntity> mpjLambdaWrapper = new MPJLambdaWrapper<MarketCouponEntity>()
                .selectAll(MarketCouponEntity.class)
                //todo 店铺报错 后期修复
                //.select(StoreInstance::getName)
                //.selectAs(MarketListCouponVo::getStoreName,StoreInstance::getName)
                .leftJoin(MarketCouponStoreEntity.class, MarketCouponStoreEntity::getCouponId, MarketCouponEntity::getId);
                //.leftJoin(StoreInstance.class,StoreInstance::getId,MarketCouponStoreEntity::getStoreId);

        mpjLambdaWrapper.eq(MarketCouponEntity::getCategoryCode,queryForm.getCategoryCode());

        if (queryForm.getMarketName() != null){
            mpjLambdaWrapper.like(MarketCouponEntity::getMarketName, queryForm.getMarketName());
        }
        if (queryForm.getStoreId() != null){
            mpjLambdaWrapper.eq(MarketCouponStoreEntity::getStoreId, queryForm.getStoreId());
        }
        if (queryForm.getMarketState() != null){
            mpjLambdaWrapper.eq(MarketCouponEntity::getStatus, queryForm.getMarketState());
        }
        if (queryForm.getStartTime() != null && queryForm.getEndTime() != null ){
            mpjLambdaWrapper.between(MarketCouponEntity::getCreateTime, queryForm.getStartTime(), queryForm.getEndTime());
        }

        mpjLambdaWrapper.orderByDesc(MarketCouponEntity::getCreateTime);
        IPage<MarketListCouponVo> page = couponMapper.selectJoinPage(new Page<MarketListCouponVo>(queryForm.getCurrent(),queryForm.getSize()) ,
                MarketListCouponVo.class,mpjLambdaWrapper);
        return page;
    }

    @Override
    public IPage<MarkerCouponRecordVo> provideGiveList(MarketProvideGiveQuery marketProvideGiveQuery) {

        return null;
    }

    @Override
    public IPage<MarkerSendCouponVo> sendCouponList(MarketSendCouponQuery marketSendCouponQuery) {
        return null;
    }
}
