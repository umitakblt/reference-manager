package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.StationRequestDTO;
import com.umitakbulut.reference_manager.dto.response.StationResponseDTO;

import java.util.List;

public interface StationService {
    StationResponseDTO save(StationRequestDTO stationRequestDTO);
    StationResponseDTO getById(Long id);
    List<StationResponseDTO> getAll();
    StationResponseDTO update(Long id, StationRequestDTO stationRequestDTO);
    void delete(Long id);
}
