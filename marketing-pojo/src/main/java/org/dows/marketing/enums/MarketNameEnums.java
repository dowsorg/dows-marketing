package org.dows.marketing.enums;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum MarketNameEnums {


    CXK("储蓄卡",10010),
    JF("积分",10011),
    YHJ("优惠券",10012),
    MJ("满减",10013),
    HY("会员",10014),
    ;

    private String name;

    private Integer code;


    public static String getMarketName(String code){
        MarketNameEnums[] values = MarketNameEnums.values();
        for (MarketNameEnums value : values) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }


    public static <T> Map<String,String> getMarketAttrCard(T clazz){
        Field[] fields = ReflectUtil.getFields(clazz.getClass());
        Map<String, String> returnMap = new LinkedHashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = ReflectUtil.getFieldValue(clazz,field);
            if(obj instanceof Date){
                obj = DateUtil.formatDateTime((Date)obj);
            }
            returnMap.put(field.getName(), obj.toString());
        }
        return returnMap;
    }


}
