package org.dows.marketing.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MarketSttingEnums {


    MARKET_SETTING_TENANT("总部设置类型","setting_t"),
    MARKET_SETTING_STORE("门店设置类型","setting_s"),

    MARKET_SETTING_NO("有权限","on"),
    MARKET_SETTING_OFF("无权限","off")
    ;

    private String name;

    private String code;


    public static String gettName(String code){
        MarketSttingEnums[] values = MarketSttingEnums.values();
        for (MarketSttingEnums value : values) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }


}
