//package com.beauty.mq.consumer;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
///**
// * todo description
// *
// * @author yufw
// * @version v0.1.0.0
// * @date 2021/1/24 15:12
// * @since v0.1.0.0
// */
//@Component
//public class ConsumerDemo {
//    /**
//     * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
//     * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
//     */
//    @KafkaListener(topics = "demo")
//    public void listen (ConsumerRecord<?, ?> record){
//        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
//
//
//    }
//}
