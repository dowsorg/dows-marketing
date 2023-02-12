package org.dows.marketing.api;

import org.dows.marketing.form.MarketCouponForm;

public interface MarketCouponApi {

    Boolean addOrUpdateCoupon(MarketCouponForm couponForm);
}
