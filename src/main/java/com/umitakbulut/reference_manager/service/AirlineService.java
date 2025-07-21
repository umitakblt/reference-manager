package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.AirlineRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AirlineResponseDTO;

import java.util.List;

public interface AirlineService {

    AirlineResponseDTO save(AirlineRequestDTO requestDTO);

    List<AirlineResponseDTO> getAllAirlines();

    AirlineResponseDTO getById(Long id);

    AirlineResponseDTO update(Long id, AirlineRequestDTO requestDTO);

    void delete(Long id);

    void deleteAll();
}