package com.beauty.tools.service;


import com.beauty.tools.config.BeautyProperties;

public class BeautyService {

    BeautyProperties helloProperties;

    public BeautyProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(BeautyProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name ) {
        return helloProperties.getPrefix()+ "-" + name + helloProperties.getSuffix()+"-"+helloProperties.getEnable();
    }
}
