package com.beauty.mq.kafka.component;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/12/28 7:02 下午
 */
public class MyInterceptor implements ProducerInterceptor {
    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        System.out.println("拦截器：序列化和计算分区前调拦截器 onSend() ");
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

        System.out.println("拦截器：消息被应答前（Acknowledgement）或发送失败时调拦截器onAcknowledgement() ，优先于用户设定Callback前执行");
    }

    @Override
    public void close() {

        System.out.println("拦截器：关闭拦截器时清理");

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
