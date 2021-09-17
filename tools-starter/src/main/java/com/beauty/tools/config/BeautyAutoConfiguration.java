package com.beauty.tools.config;

import com.beauty.tools.service.BeautyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author yufw
 */
@Configuration
@EnableConfigurationProperties(BeautyProperties.class)
@ConditionalOnProperty(
        prefix = "beauty",
        name = "enable",
        havingValue = "true"
)
public class BeautyAutoConfiguration {

    @Resource
    BeautyProperties beautyProperties;

    @Bean
    public BeautyService helloService() {
        BeautyService service = new BeautyService();
        service.setHelloProperties(beautyProperties);
        return service;
    }


}
