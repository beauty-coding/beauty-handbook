package com.beauty.mq.kafka.component;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * description
 *
 *      * 自定义分区器
 *      * 我们知道，kafka中每个topic被划分为多个分区，那么生产者将消息发送到topic时，具体追加到哪个分区呢？这就是所谓的分区策略，Kafka 为我们提供了默认的分区策略，同时它也支持自定义分区策略。其路由机制为：
 *      * ① 若发送消息时指定了分区（即自定义分区策略），则直接将消息append到指定分区；
 *      * ② 若发送消息时未指定 patition，但指定了 key（kafka允许为每条消息设置一个key），则对key值进行hash计算，根据计算结果路由到指定分区，这种情况下可以保证同一个 Key 的所有消息都进入到相同的分区；
 *      * ③  patition 和 key 都未指定，则使用kafka默认的分区策略，轮询选出一个 patition；
 *      * ※ 我们来自定义一个分区策略，将消息发送到我们指定的partition，首先新建一个分区器类实现Partitioner接口，重写方法，其中partition方法的返回值就表示将消息发送到几号分区，
 *      *
 *
 * @author yufengwen
 * @date 2021/12/20 2:27 下午
 */
public class MyPartition implements Partitioner {
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        System.out.println(s);
        System.out.println(o);
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void onNewBatch(String topic, Cluster cluster, int prevPartition) {
        Partitioner.super.onNewBatch(topic, cluster, prevPartition);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
