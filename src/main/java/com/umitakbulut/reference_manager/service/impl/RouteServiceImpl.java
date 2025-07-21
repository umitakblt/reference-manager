package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.RouteRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RouteResponseDTO;
import com.umitakbulut.reference_manager.entity.Route;
import com.umitakbulut.reference_manager.mapper.RouteMapper;
import com.umitakbulut.reference_manager.repository.RouteRepository;
import com.umitakbulut.reference_manager.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    @Override
    public RouteResponseDTO save(RouteRequestDTO requestDTO) {
        Route route = routeMapper.toEntity(requestDTO);
        Route saved = routeRepository.save(route);
        return routeMapper.toResponseDto(saved);
    }

    @Override
    public List<RouteResponseDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteResponseDTO getById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
        return routeMapper.toResponseDto(route);
    }

    @Override
    public RouteResponseDTO update(Long id, RouteRequestDTO requestDTO) {
        Route existing = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));

        Route updated = routeMapper.toEntity(requestDTO);
        updated.setId(existing.getId());

        Route saved = routeRepository.save(updated);
        return routeMapper.toResponseDto(saved);
    }

    @Override
    public void delete(Long id) {
        routeRepository.deleteById(id);
    }
}