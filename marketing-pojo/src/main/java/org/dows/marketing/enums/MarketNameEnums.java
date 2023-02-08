package org.dows.marketing.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dows.marketing.bo.MarketCardAttrValBo;
import org.dows.marketing.bo.MarketIntegralAttValBo;

import java.util.HashMap;
import java.util.HashSet;
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

    public static String[] cardAttrName = new String[]{"recharge","amount"};
    public static Map<String,String> getCardAttrVal(MarketCardAttrValBo attrValBo){
        Map<String, String> cardMap = new HashMap<>();
        cardMap.put(cardAttrName[0],attrValBo.getRecharge().toString());
        cardMap.put(cardAttrName[1],attrValBo.getAmount().toString());
        return cardMap;
    }
    public static String[] integralAttrName = new String[]{"integer","amount"};
    public static Map<String,String> getIntegralAttrVal(MarketIntegralAttValBo.Integeral integeral){
        Map<String, String> cardMap = new HashMap<>();
        cardMap.put(integralAttrName[0],integeral.getInteger().toString());
        cardMap.put(integralAttrName[1],integeral.getAmount().toString());
        return cardMap;
    }
    public static String[] returnIntegralAttrName = new String[]{"useAmount","returnInteger"};
    public static Map<String,String> getReturnIntegralAttrNameAttrVal(MarketIntegralAttValBo.ReturnIntegeral attValBo){
        Map<String, String> cardMap = new HashMap<>();
        cardMap.put(returnIntegralAttrName[0],attValBo.getUseAmount().toString());
        cardMap.put(returnIntegralAttrName[1],attValBo.getReturnInteger().toString());
        return cardMap;
    }

}
