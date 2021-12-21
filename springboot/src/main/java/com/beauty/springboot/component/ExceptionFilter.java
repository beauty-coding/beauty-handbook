package com.beauty.springboot.component;

import com.beauty.springboot.model.FilterRequest;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFilter implements Filter {

    @Override
    public boolean filter(FilterRequest request) {
        System.out.println("异常拦截处理");
        return true;
    }
}