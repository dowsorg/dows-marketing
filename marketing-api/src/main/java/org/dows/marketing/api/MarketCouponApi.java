package org.dows.marketing.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.dows.marketing.form.MarketCouponForm;
import org.dows.marketing.form.MarketCouponQueryForm;
import org.dows.marketing.form.MarketListCouponVo;
import org.dows.marketing.form.SentCouponForm;

public interface MarketCouponApi {

    Boolean addOrUpdateCoupon(MarketCouponForm couponForm);

    Boolean senCoupon(SentCouponForm sentCoupon);

    IPage<MarketListCouponVo> getCouponList(MarketCouponQueryForm queryForm);
}
