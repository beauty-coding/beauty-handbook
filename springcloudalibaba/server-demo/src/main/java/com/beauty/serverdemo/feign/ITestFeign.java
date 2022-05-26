package com.beauty.serverdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/5/23 20:56
 */
@FeignClient(value = "nacos-provider",fallback = TestFeignFallback.class)
public interface ITestFeign {
    @GetMapping("/test")
    Map<String,Object> test();
}
