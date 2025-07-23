package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.FlightRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightResponseDTO;
import com.umitakbulut.reference_manager.entity.*;
import com.umitakbulut.reference_manager.kafka.KafkaProducer;
import com.umitakbulut.reference_manager.mapper.FlightMapper;
import com.umitakbulut.reference_manager.repository.*;
import com.umitakbulut.reference_manager.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;
    private final StationRepository stationRepository;
    private final FlightTypeRepository flightTypeRepository;

    private final KafkaProducer kafkaProducer;

    @Override
    public FlightResponseDTO addFlight(FlightRequestDTO requestDTO) {
        Flight flight = mapFlightRequestToEntity(requestDTO);
        Flight saved = flightRepository.save(flight);

        kafkaProducer.sendFlight(saved);

        return flightMapper.toDto(saved);
    }

    @Override
    public FlightResponseDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
        return flightMapper.toDto(flight);
    }

    @Override
    public List<FlightResponseDTO> getAllFlights() {
        return flightMapper.toDtoList(flightRepository.findAll());
    }

    @Override
    public FlightResponseDTO updateFlight(Long id, FlightRequestDTO requestDTO) {
        Flight existing = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));

        existing.setFlightNumber(requestDTO.getFlightNumber());
        existing.setScheduledDeparture(requestDTO.getScheduledDeparture());
        existing.setScheduledArrival(requestDTO.getScheduledArrival());
        existing.setAircraft(getAircraft(requestDTO.getAircraftId()));
        existing.setAirline(getAirline(requestDTO.getAirlineId()));
        existing.setOriginStation(getStation(requestDTO.getOriginStationId()));
        existing.setDestinationStation(getStation(requestDTO.getDestinationStationId()));
        existing.setFlightType(getFlightType(requestDTO.getFlightTypeId()));

        Flight saved = flightRepository.save(existing);

        kafkaProducer.sendFlight(saved);

        return flightMapper.toDto(saved);
    }


    @Override
    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flight not found with id: " + id);
        }
        flightRepository.deleteById(id);
    }

    private Flight mapFlightRequestToEntity(FlightRequestDTO dto) {
        Flight flight = flightMapper.toEntity(dto);
        flight.setAircraft(getAircraft(dto.getAircraftId()));
        flight.setAirline(getAirline(dto.getAirlineId()));
        flight.setOriginStation(getStation(dto.getOriginStationId()));
        flight.setDestinationStation(getStation(dto.getDestinationStationId()));
        flight.setFlightType(getFlightType(dto.getFlightTypeId()));
        return flight;
    }

    private Aircraft getAircraft(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found with id: " + id));
    }

    private Airline getAirline(Long id) {
        return airlineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Airline not found with id: " + id));
    }

    private Station getStation(Long id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Station not found with id: " + id));
    }

    private FlightType getFlightType(Long id) {
        return flightTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight Type not found with id: " + id));
    }
}