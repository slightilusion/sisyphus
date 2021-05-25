package cc.yelcat.sisyphus.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    // 消费监听
    @KafkaListener(groupId = "test",topics = {"topic1"})
    public void listen1(String data) {
        System.out.println(data);
    }
}