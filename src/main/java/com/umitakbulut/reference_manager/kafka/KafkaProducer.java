package com.umitakbulut.reference_manager.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umitakbulut.reference_manager.entity.Flight;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPIC_NAME = "flight-topic";

    public void sendFlight(Flight flight) {
        try {
            String message = objectMapper.writeValueAsString(flight);
            kafkaTemplate.send(TOPIC_NAME, message);
            log.info("Kafka'ya gönderildi: {}", message);
        } catch (JsonProcessingException e) {
            log.error("Kafka mesajı JSON'a dönüştürülemedi", e);
        }
    }
}