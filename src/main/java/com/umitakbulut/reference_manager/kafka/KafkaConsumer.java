package com.umitakbulut.reference_manager.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umitakbulut.reference_manager.entity.Flight;
import com.umitakbulut.reference_manager.service.FlightArchiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private final FlightArchiveService archiveService;

    @KafkaListener(topics = "flight-topic", groupId = "flight-group")
    public void consume(String message) {
        try {
            Flight flight = objectMapper.readValue(message, Flight.class);
            archiveService.saveFromFlight(flight);
            log.info("Kafka'dan alındı ve archive'e kaydedildi: {}", message);
        } catch (Exception e) {
            log.error("Mesaj tüketilirken hata oluştu", e);
        }
    }
}