package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.FlightRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightResponseDTO;

import java.util.List;

public interface FlightService {

    FlightResponseDTO addFlight(FlightRequestDTO flightRequestDTO);

    FlightResponseDTO getFlightById(Long id);

    List<FlightResponseDTO> getAllFlights();

    FlightResponseDTO updateFlight(Long id, FlightRequestDTO flightRequestDTO);

    void deleteFlight(Long id);
}
