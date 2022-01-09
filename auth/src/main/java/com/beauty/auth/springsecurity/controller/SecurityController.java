package com.beauty.auth.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
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