package org.dows.marketing.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.Map;

@Getter
@AllArgsConstructor
public enum MarketNameEnums {


    YHJ("优惠券","YHJ"),
    JF("积分","JF"),
    CXK("储蓄卡","CXK"),
    MJ("满减","MJ"),
    HY("会员","HY"),
    ;

    private String name;

    private String code;


    public static String getMarketName(String code){
        MarketNameEnums[] values = MarketNameEnums.values();
        for (MarketNameEnums value : values) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }
}
