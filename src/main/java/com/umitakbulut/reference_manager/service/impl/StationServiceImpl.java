package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.StationRequestDTO;
import com.umitakbulut.reference_manager.dto.response.StationResponseDTO;
import com.umitakbulut.reference_manager.entity.Station;
import com.umitakbulut.reference_manager.mapper.StationMapper;
import com.umitakbulut.reference_manager.repository.StationRepository;
import com.umitakbulut.reference_manager.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    @Override
    public StationResponseDTO save(StationRequestDTO requestDTO) {
        Station station = stationMapper.toEntity(requestDTO);
        Station saved = stationRepository.save(station);
        return stationMapper.toResponseDto(saved);
    }

    @Override
    public List<StationResponseDTO> getAll() {
        return stationRepository.findAll()
                .stream()
                .map(stationMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public StationResponseDTO getById(Long id) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));
        return stationMapper.toResponseDto(station);
    }

    @Override
    public StationResponseDTO update(Long id, StationRequestDTO requestDTO) {
        Station existing = stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));
        Station updated = stationMapper.toEntity(requestDTO);
        updated.setId(existing.getId());
        return stationMapper.toResponseDto(stationRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        stationRepository.deleteById(id);
    }
}
