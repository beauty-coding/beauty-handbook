package com.beauty.springboot.controller;

import com.beauty.starter.BeautyService;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/rest")
public class DemoApi {

    @Resource
    private BeautyService beautyService;

    /**
     * value：抛出指定异常才会重试
     *  include：和value一样，默认为空，当exclude也为空时，默认所以异常
     *  exclude：指定不处理的异常
     *  maxAttempts：最大重试次数，默认3次
     *  backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；multiplier（指定延迟倍数）   默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
     * @param param
     * @return
     */
    @Retryable(value= {RemoteAccessException.class},maxAttempts = 4,backoff = @Backoff(delay = 5000,multiplier = 1))
    @GetMapping("/test/get")
    public String testGet(String param){

        System.out.println("重试 - --------");
        throw new RemoteAccessException("test");
    }


    @GetMapping("/test/get/{param}")
    public String testGetParam(@PathVariable String param){
        return param;
    }

    @PostMapping("/test/post")
    public Map testPost(@RequestBody Map param){
        return param;
    }

    @GetMapping("/test/starter")
    public Object testStarter(){
        return beautyService.sayHello("beauty");
    }

}
