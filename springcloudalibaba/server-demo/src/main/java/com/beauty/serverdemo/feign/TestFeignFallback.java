package com.beauty.serverdemo.feign;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/5/23 20:57
 */
@Component
public class TestFeignFallback implements  ITestFeign{

    @Override
    public Map<String, Object> test() {
        Map<String,Object> rst = new HashMap<>();
        rst.put("msg","请求熔断处理");
        return rst;
    }
}