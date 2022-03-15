package com.beauty.mq.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/12/17 5:34 下午
 */
@RequestMapping("/producer")
@RestController
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 简单的消息生产者
     *
     * @param normalMessage
     */
    @GetMapping("/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("topic1", normalMessage);
    }


    /**
     * 带回调的生产者 实现一
     *
     * @param callbackMessage
     */
    @GetMapping("/callbackOne/{message}")
    public void sendMessage2(@PathVariable("message") String callbackMessage) {
        kafkaTemplate.send("topic1", callbackMessage).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            System.out.println("发送消息失败:" + failure.getMessage());
            System.out.println("发送消息失败:可以进行一定重试补偿" + failure.getMessage());
        });
    }


    /**
     * 带回调的 生产者 实现二
     *
     * @param callbackMessage
     */
    @GetMapping("/callbackTwo/{message}")
    public void sendMessage3(@PathVariable("message") String callbackMessage) {
        kafkaTemplate.send("topic1", callbackMessage).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("发送消息失败：" + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }
        });
    }

    /**
     * 如果在发送消息时需要创建事务，可以使用 KafkaTemplate 的 executeInTransaction 方法来声明事务，
     * @param message
     */
    @GetMapping("/transaction/{message}")
    public void sendMessage7(@PathVariable("message") String message) {
        // 声明事务：后面报错消息不会发出去
        kafkaTemplate.executeInTransaction(operations -> {
            System.out.println("test executeInTransaction");
            final ListenableFuture<SendResult<String, Object>> resultListenableFuture = operations.send("topic1", message);
            throw new RuntimeException("fail");
//            return resultListenableFuture;
        });
//
//        // 不声明事务：后面报错但前面消息已经发送成功了
//        kafkaTemplate.send("topic1", message);
//        throw new RuntimeException("fail");

    }


}
