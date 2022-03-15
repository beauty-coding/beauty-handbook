package com.beauty.wechat.controller;

import com.beauty.wechat.annotation.Permission;
import com.beauty.wechat.annotation.SourceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/30 4:37 下午
 */
@RestController
public class DemoController {

    @Permission(sourceType = SourceType.WECHAT)
    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
