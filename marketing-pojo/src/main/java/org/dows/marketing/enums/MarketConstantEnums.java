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
public enum MarketConstantEnums {


    LQ_ZDLQ("自动领取",11),
    LQ_SDLQ("手动领取",12),

    TS_LQTX("优惠券领取提醒",21),
    TS_DZTX("优惠券到账通知",22)
    ;

    private String name;

    private Integer code;


    public static String getMarketName(String code){
        MarketConstantEnums[] values = MarketConstantEnums.values();
        for (MarketConstantEnums value : values) {
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
