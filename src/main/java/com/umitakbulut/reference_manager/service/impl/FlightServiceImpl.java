package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.FlightRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightResponseDTO;
import com.umitakbulut.reference_manager.entity.*;
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

    @Override
    public FlightResponseDTO addFlight(FlightRequestDTO requestDTO) {
        Flight flight = flightMapper.toEntity(requestDTO);

        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found with id: " + requestDTO.getAircraftId()));
        flight.setAircraft(aircraft);

        Airline airline = airlineRepository.findById(requestDTO.getAirlineId())
                .orElseThrow(() -> new ResourceNotFoundException("Airline not found with id: " + requestDTO.getAirlineId()));
        flight.setAirline(airline);

        Station origin = stationRepository.findById(requestDTO.getOriginStationId())
                .orElseThrow(() -> new ResourceNotFoundException("Origin Station not found with id: " + requestDTO.getOriginStationId()));
        flight.setOriginStation(origin);

        Station destination = stationRepository.findById(requestDTO.getDestinationStationId())
                .orElseThrow(() -> new ResourceNotFoundException("Destination Station not found with id: " + requestDTO.getDestinationStationId()));
        flight.setDestinationStation(destination);

        FlightType flightType = flightTypeRepository.findById(requestDTO.getFlightTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Flight Type not found with id: " + requestDTO.getFlightTypeId()));
        flight.setFlightType(flightType);

        Flight saved = flightRepository.save(flight);
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

        // Temel alanları güncelle
        existing.setFlightNumber(requestDTO.getFlightNumber());
        existing.setScheduledDeparture(requestDTO.getScheduledDeparture());
        existing.setScheduledArrival(requestDTO.getScheduledArrival());

        // İlişkisel entityleri güncelle
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found with id: " + requestDTO.getAircraftId()));
        existing.setAircraft(aircraft);

        Airline airline = airlineRepository.findById(requestDTO.getAirlineId())
                .orElseThrow(() -> new ResourceNotFoundException("Airline not found with id: " + requestDTO.getAirlineId()));
        existing.setAirline(airline);

        Station origin = stationRepository.findById(requestDTO.getOriginStationId())
                .orElseThrow(() -> new ResourceNotFoundException("Origin Station not found with id: " + requestDTO.getOriginStationId()));
        existing.setOriginStation(origin);

        Station destination = stationRepository.findById(requestDTO.getDestinationStationId())
                .orElseThrow(() -> new ResourceNotFoundException("Destination Station not found with id: " + requestDTO.getDestinationStationId()));
        existing.setDestinationStation(destination);

        FlightType flightType = flightTypeRepository.findById(requestDTO.getFlightTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Flight Type not found with id: " + requestDTO.getFlightTypeId()));
        existing.setFlightType(flightType);

        Flight saved = flightRepository.save(existing);
        return flightMapper.toDto(saved);
    }

    @Override
    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flight not found with id: " + id);
        }
        flightRepository.deleteById(id);
    }
}