package com.beauty.mq.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/12/17 5:35 下午
 */
@Component
public class KafkaConsumer {
    // 消费监听
    @KafkaListener(topics = {"topic1"}
            , errorHandler = "consumerAwareErrorHandler"
            , containerFactory = "filterContainerFactory")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费：topic" + record.topic() + "-partition:" + record.partition() + "-offset:" + record.offset() + "-value:" + record.value());

//        throw new RuntimeException("异常消费");
    }

    /**
     * @Title 指定topic、partition、offset消费
     * @Description 同时监听topic1和topic2，监听topic1的0号分区、topic2的 "0号和1号" 分区，指向1号分区的offset初始值为8
     * 属性解释：
     * <p>
     * ① id：消费者ID；
     * <p>
     * ② groupId：消费组ID；
     * <p>
     * ③ topics：监听的topic，可监听多个；
     * <p>
     * ④ topicPartitions：可配置更加详细的监听信息，可指定topic、parition、offset监听。
     * <p>
     * 上面onMessage2监听的含义：监听topic1的0号分区，同时监听topic2的0号分区和topic2的1号分区里面offset从8开始的消息。
     * <p>
     * 注意：topics和topicPartitions不能同时使用；
     **/
    @KafkaListener(id = "consumer1", groupId = "felix-group", topicPartitions = {
            @TopicPartition(topic = "topic1", partitions = {"0"}),
            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
    })
    public void onMessage2(ConsumerRecord<?, ?> record) {
        System.out.println("指定分区消费：topic:" + record.topic() + "-partition:" + record.partition() + "-offset:" + record.offset() + "-value:" + record.value());
    }

//    // == 批量消费
//    @KafkaListener(id = "consumer2",groupId = "batch-group", topics = "topic1")
//    public void onMessage3(List<ConsumerRecord<?, ?>> records) {
//        System.out.println(">>>批量消费一次，records.size()="+records.size());
//        for (ConsumerRecord<?, ?> record : records) {
//            System.out.println("topic:" + record.topic() + "-partition:" + record.partition() + "-offset:" + record.offset() + "-value:" + record.value());
//
//        }
//    }


    /**
     * @Title 消息转发
     * @Description 从topic1接收到的消息经过处理后转发到topic2
     **/
    @KafkaListener(topics = {"topic1"}, groupId = "forward-group")
    @SendTo("topic2")
    public String onMessage7(ConsumerRecord<?, ?> record) {
        return record.value() + "-forward message";
    }

    // 消费监听
    @KafkaListener(topics = {"topic2"})
    public void onMessage8(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费：topic" + record.topic() + "-partition:" + record.partition() + "-offset:" + record.offset() + "-value:" + record.value());

    }


}
