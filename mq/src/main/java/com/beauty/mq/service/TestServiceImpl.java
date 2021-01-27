package com.beauty.mq.service;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Set;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/24 15:29
 * @since v0.1.0.0
 */
public class TestServiceImpl {

    @Resource
    private KafkaConsumer kafkaConsumer;

    public void testConsumer(){

        kafkaConsumer.subscribe(Collections.singleton("demo"));
        final Set<TopicPartition> assignment = kafkaConsumer.assignment();

    }
}
