package com.beauty.springboot.component;

import com.beauty.springboot.model.FilterRequest;
import org.springframework.stereotype.Component;

@Component
public class ParamFilter implements Filter{
    @Override
    public boolean filter(FilterRequest request) {
        System.out.println("入参校验处理");
        return true;
    }
}