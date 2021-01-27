package com.beauty.mq.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/24 15:12
 * @since v0.1.0.0
 */
@Component
public class ConsumersDemo {

    @KafkaListener(containerFactory = "batchFactory",topics = "demo")
    public void listen (List<ConsumerRecord<?, ?>> consumerRecords, Acknowledgment ack){

        System.out.printf("消息数,%s", consumerRecords);



        ack.acknowledge();

    }
}
