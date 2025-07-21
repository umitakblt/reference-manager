package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.StationRequestDTO;
import com.umitakbulut.reference_manager.dto.response.StationResponseDTO;
import com.umitakbulut.reference_manager.entity.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {
    Station toEntity(StationRequestDTO dto);
    StationResponseDTO toResponseDto(Station station);
}
