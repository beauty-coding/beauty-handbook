package com.beauty.springboot.service;

import com.beauty.springboot.component.Filter;
import com.beauty.springboot.model.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDealService {

    @Autowired
    private List<Filter> filterList;

    public void doWork(){
        // 一顿输出 组装出 过滤入参
        final FilterRequest filterRequest = new FilterRequest();
        // 过滤器 处理
        if (!filterList.isEmpty()) {
            for (Filter filter : filterList) {
                // 过滤不通过直接 结束
                if (!filter.filter(filterRequest)) {

                    return;
                }
            }
        }

        System.out.println("所有的 前置过滤已完成，执行具体的业务处理");
    }

}
