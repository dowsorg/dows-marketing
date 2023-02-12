package org.dows.marketing.enums;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum MarketConstant {


    LQ_ZDLQ("自动领取",11),
    LQ_SDLQ("手动领取",12),

    TS_LQTX("优惠券领取提醒",21),
    TS_DZTX("优惠券到账通知",22)
    ;

    private String name;

    private Integer code;


    public static String getMarketName(String code){
        MarketConstant[] values = MarketConstant.values();
        for (MarketConstant value : values) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }


}
