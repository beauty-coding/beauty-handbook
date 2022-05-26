package com.beauty.serverdemo.controller;

import com.beauty.serverdemo.service.IpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    final IpInfoService ipInfoService;

    @Value("${test.demo}")
    private String demo;

    public ConfigController(IpInfoService ipInfoService) {
        this.ipInfoService = ipInfoService;
    }

    @GetMapping("/config/info")
    public String configInfo(){
        return demo;
    }
    @GetMapping(value = "/ip")
    public ResponseEntity welCome() {
        return ipInfoService.getIpInfo();
    }

}
