package com.beauty.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/9/9 11:22 上午
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${test.demo}")
    private String demo;

    @GetMapping("/config/info")
    public String configInfo(){
        return demo;
    }
}
