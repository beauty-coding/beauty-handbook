package com.beauty.mq.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/24 15:36
 * @since v0.1.0.0
 */
@Service
public class ConsumerService implements AcknowledgingMessageListener<Integer, String> {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private static final Integer INSERT_BATCH_COUNT = 50;

    /**
     * 消息监听方法
     * @param record
     */

    @Override
    public void onMessage(ConsumerRecord<Integer, String> record, Acknowledgment acknowledgment) {
        logger.info("Before receiving:" + record.toString());
        String value = record.value();
        try {
            acknowledgment.acknowledge();//提交offset
        } catch (Exception e) {
            e.printStackTrace();
        }
        //insert(record);
        //insertBatch(record);
    }
}
