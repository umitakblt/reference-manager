package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.AirlineRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AirlineResponseDTO;
import com.umitakbulut.reference_manager.entity.Airline;
import com.umitakbulut.reference_manager.mapper.AirlineMapper;
import com.umitakbulut.reference_manager.repository.AirlineRepository;
import com.umitakbulut.reference_manager.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper;

    @Override
    public AirlineResponseDTO save(AirlineRequestDTO requestDTO) {
        Airline airline = airlineMapper.toEntity(requestDTO);
        Airline saved = airlineRepository.save(airline);
        return airlineMapper.toResponseDto(saved);
    }

    @Override
    public List<AirlineResponseDTO> getAllAirlines() {
        return airlineRepository.findAll()
                .stream()
                .map(airlineMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirlineResponseDTO getById(Long id) {
        Airline airline = airlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airline not found"));
        return airlineMapper.toResponseDto(airline);
    }

    @Override
    public AirlineResponseDTO update(Long id, AirlineRequestDTO requestDTO) {
        Airline existing = airlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airline not found"));
        Airline updated = airlineMapper.toEntity(requestDTO);
        updated.setId(existing.getId());
        Airline saved = airlineRepository.save(updated);
        return airlineMapper.toResponseDto(saved);
    }

    @Override
    public void delete(Long id) {
        airlineRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        airlineRepository.deleteAll();
    }
}