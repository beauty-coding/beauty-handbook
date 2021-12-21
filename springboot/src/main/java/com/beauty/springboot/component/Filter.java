package com.beauty.springboot.component;

import com.beauty.springboot.model.FilterRequest;

public interface Filter{
    boolean filter(FilterRequest request);
}