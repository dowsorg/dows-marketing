package org.dows.marketing.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MarketSttingEnums {


    MARKET_SETTING_TENANT("总部是否授权门店","setting_t"),
    MARKET_SETTING_OPEN_TENANT("总部营销状态启开关","setting_open_t"),
    MARKET_SETTING_OPEN_STORE("总部开启门店营销状态","setting_open_s"),

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
