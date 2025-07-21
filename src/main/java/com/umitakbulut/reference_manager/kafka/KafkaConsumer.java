package com.umitakbulut.reference_manager.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "flights", groupId = "group_id")
    public void consume(String message) {
        log.info("Consumed message: {}", message);
    }
}
