package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.AirlineRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AirlineResponseDTO;
import com.umitakbulut.reference_manager.entity.Airline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    Airline toEntity(AirlineRequestDTO dto);
    AirlineResponseDTO toResponseDto(Airline airline);
}
