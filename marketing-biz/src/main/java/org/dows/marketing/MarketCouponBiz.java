package org.dows.marketing;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dows.framework.api.Response;
import org.dows.marketing.api.MarketCouponApi;
import org.dows.marketing.entity.MarketCouponEntity;
import org.dows.marketing.entity.MarketCouponStoreEntity;
import org.dows.marketing.form.MarketCouponForm;
import org.dows.marketing.form.MarketCouponQueryForm;
import org.dows.marketing.form.MarketListCouponVo;
import org.dows.marketing.mapper.MarketCouponMapperJoin;
import org.dows.marketing.service.MarketCouponService;
import org.dows.marketing.service.MarketCouponStoreService;
import org.dows.marketing.service.MarketNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public IPage getCouponList(MarketCouponQueryForm queryForm) {

        MPJLambdaWrapper<MarketCouponEntity> mpjLambdaWrapper = new MPJLambdaWrapper<MarketCouponEntity>()
                .selectAll(MarketCouponEntity.class)
                //todo 店铺报错 后期修复
                //.select(StoreInstance::getName)
                //.selectAs(MarketListCouponVo::getStoreName,StoreInstance::getName)
                .leftJoin(MarketCouponStoreEntity.class, MarketCouponStoreEntity::getCouponId, MarketCouponEntity::getId);
                //.leftJoin(StoreInstance.class,StoreInstance::getId,MarketCouponStoreEntity::getStoreId);

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
}
