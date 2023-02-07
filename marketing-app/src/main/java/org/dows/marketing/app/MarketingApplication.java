package org.dows.marketing.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @description
*
* @author 
* @date 2023年2月6日 下午6:05:20
*/
@SpringBootApplication(scanBasePackages = {"org.dows.framework","org.dows.*"})
public class MarketingApplication{
    public static void main(String[] args) {
        SpringApplication.run(MarketingApplication.class, args);
    }
}

