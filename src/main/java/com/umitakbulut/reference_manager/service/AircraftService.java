package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.AircraftRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AircraftResponseDTO;
import com.umitakbulut.reference_manager.entity.Aircraft;

import java.util.List;

public interface AircraftService {
    AircraftResponseDTO save(AircraftRequestDTO aircraftRequestDTO);
    AircraftResponseDTO getById(Long id);
    List<AircraftResponseDTO> getAll();
    AircraftResponseDTO update(Long id, AircraftRequestDTO aircraftRequestDTO);
    void delete(Long id);
}
