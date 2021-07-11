package com.beauty.springboot.controller;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TestThreadPool {

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor executor;


    @GetMapping("/test")
    public List<Integer> test() throws ExecutionException, InterruptedException {

        //使用Future方式执行多任务
        //生成一个集合
        List<Future> futures = new ArrayList<>();

        //获取后台全部有效运营人员的集合
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }


        for (Integer item : list) {
            //并发处理
                Future<?> future = executor.submit(() -> item + 2);
                futures.add(future);
        }

        List<Integer> result = new ArrayList<>();

        //查询任务执行的结果
        for (Future<?> future : futures) {
            while (true) {//CPU高速轮询：每个future都并发轮循，判断完成状态然后获取结果，这一行，是本实现方案的精髓所在。即有10个future在高速轮询，完成一个future的获取结果，就关闭一个轮询
                if (future.isDone() && !future.isCancelled()) {//获取future成功完成状态，如果想要限制每个任务的超时时间，取消本行的状态判断+future.get(1000*1, TimeUnit.MILLISECONDS)+catch超时异常使用即可。
                    Integer i = (Integer) future.get();//获取结果
                    System.out.println("任务i=" + i + "获取完成!" + new Date());
                    result.add(i);
                    break;//当前future获取结果完毕，跳出while
                } else {
                    Thread.sleep(1);//每次轮询休息1毫秒（CPU纳秒级），避免CPU高速轮循耗空CPU---》新手别忘记这个
                }

            }

        }
        return result;
    }

}