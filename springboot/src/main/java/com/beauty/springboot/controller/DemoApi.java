package com.beauty.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class DemoApi {

    @GetMapping("/test/get")
    public String testGet(String param){
        return param;
    }


    @GetMapping("/test/get/{param}")
    public String testGetParam(@PathVariable String param){
        return param;
    }

    @PostMapping("/test/post")
    public Map testPost(@RequestBody Map param){
        return param;
    }
}
