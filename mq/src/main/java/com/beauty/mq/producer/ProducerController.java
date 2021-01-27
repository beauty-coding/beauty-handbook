package com.beauty.mq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/24 15:13
 * @since v0.1.0.0
 */
@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @RequestMapping("message/send")
    public String send(String msg){
        //使用kafka模板发送信息
        kafkaTemplate.send("demo", msg);
        return "success";
    }
}
