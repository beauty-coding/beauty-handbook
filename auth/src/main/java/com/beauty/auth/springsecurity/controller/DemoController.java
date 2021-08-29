package com.beauty.auth.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/8/27 9:42 上午
 */
@RestController
public class DemoController {
    @RequestMapping("/hello")
    String home() {
        return "Hello ,spring security!";
    }
    @RequestMapping("/product/info")
    public String productInfo() {
        return " some pro";
    }

    @RequestMapping("/admin/home")
    public String adminHome() {
        return " admin home page ";
    }

}
