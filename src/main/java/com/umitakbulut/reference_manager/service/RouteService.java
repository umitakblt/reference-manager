package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.RouteRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RouteResponseDTO;

import java.util.List;

public interface RouteService {

    RouteResponseDTO save(RouteRequestDTO requestDTO);
    RouteResponseDTO getById(Long id);
    List<RouteResponseDTO> getAll();
    RouteResponseDTO update(Long id, RouteRequestDTO requestDTO);
    void delete(Long id);
}
