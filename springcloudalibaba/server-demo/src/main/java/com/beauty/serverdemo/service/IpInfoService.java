package com.beauty.serverdemo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class IpInfoService {

    @SentinelResource(value = "ip_info", blockHandler = "exceptionHandler")
    public ResponseEntity getIpInfo() {
        String result = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            result = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

}