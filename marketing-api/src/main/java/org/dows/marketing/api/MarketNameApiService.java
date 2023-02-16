package org.dows.marketing.api;

import org.dows.marketing.form.MarketCardNameForm;
import org.dows.marketing.form.MarketIntegralNameForm;
import org.dows.marketing.form.MarketQueryNameForm;
import org.dows.marketing.vo.MarketCardAttrValVo;
import org.dows.marketing.vo.MarketIntegralAttrValVo;

import java.util.List;

public interface MarketNameApiService {

    void addMarketCardName(MarketCardNameForm nameForm);


    List<MarketCardAttrValVo> getMarketCardName(MarketQueryNameForm nameForm);


    boolean removeMarketCardName(String marketNametId);



    void addMarketIntegral(MarketIntegralNameForm integralNameForm);


    List<MarketIntegralAttrValVo> getIntegralName(MarketQueryNameForm nameForm);

    /**
     * 获取营销名称配置通用
     * @param marketNameId
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getMarketCardAttrVal(String marketNameId,Class<T> clazz);

}
