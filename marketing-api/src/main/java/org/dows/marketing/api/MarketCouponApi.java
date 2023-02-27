package org.dows.marketing.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.dows.marketing.form.*;
import org.dows.marketing.vo.MarkerCouponRecordVo;

public interface MarketCouponApi {

    Boolean addOrUpdateCoupon(MarketCouponForm couponForm);

    Boolean senCoupon(SentCouponForm sentCoupon);

    IPage<MarketListCouponVo> getCouponList(MarketCouponQueryForm queryForm);

    /**
     * 优惠卷-发放记录列表
     * @param marketProvideGiveQuery
     * @return
     */
    IPage<MarkerCouponRecordVo> provideGiveList(MarketProvideGiveQuery marketProvideGiveQuery);

}
