package com.umitakbulut.reference_manager.cvs;

import com.umitakbulut.reference_manager.entity.Flight;
import com.umitakbulut.reference_manager.repository.FlightRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightCsvServiceImpl implements FlightCsvService {

    private static final Logger logger = LoggerFactory.getLogger(FlightCsvServiceImpl.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private final FlightRepository flightRepository;
    private final FlightCsvMapper flightCsvMapper;

    public FlightCsvServiceImpl(FlightRepository flightRepository, FlightCsvMapper flightCsvMapper) {
        this.flightRepository = flightRepository;
        this.flightCsvMapper = flightCsvMapper;
    }

    @Override
    @Transactional
    public List<Flight> importFlightsFromCsv(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim())) {

            List<FlightCsvDTO> dto = parser.getRecords().stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());

            List<Flight> flights = dto.stream()
                    .map(flightCsvMapper::fromCsvDto)
                    .collect(Collectors.toList());

            return flightRepository.saveAll(flights);

        } catch (Exception e) {
            logger.error("CSV içe aktarım hatası: {}", e.getMessage(), e);
            throw new RuntimeException("CSV dosyası işlenemedi", e);
        }
    }

    private FlightCsvDTO toDto(CSVRecord record) {
        FlightCsvDTO dto = new FlightCsvDTO();
        dto.setFlightNumber(record.get("flightNumber"));
        dto.setAircraftId(Long.parseLong(record.get("aircraftId")));
        dto.setAirlineId(Long.parseLong(record.get("airlineId")));
        dto.setOriginStationId(Long.parseLong(record.get("originStationId")));
        dto.setDestinationStationId(Long.parseLong(record.get("destinationStationId")));
        dto.setFlightTypeId(Long.parseLong(record.get("flightTypeId")));
        dto.setScheduledDeparture(LocalDateTime.parse(record.get("scheduledDeparture"), FORMATTER));
        dto.setScheduledArrival(LocalDateTime.parse(record.get("scheduledArrival"), FORMATTER));
        return dto;
    }
}