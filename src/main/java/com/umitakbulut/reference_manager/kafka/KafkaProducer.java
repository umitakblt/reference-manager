package com.umitakbulut.reference_manager.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "flights";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
