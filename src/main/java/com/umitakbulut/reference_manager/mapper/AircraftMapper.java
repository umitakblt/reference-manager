package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.AircraftRequestDTO;
import com.umitakbulut.reference_manager.dto.request.AirlineRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AircraftResponseDTO;
import com.umitakbulut.reference_manager.entity.Aircraft;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftMapper {
    Aircraft toEntity(AircraftRequestDTO dto);
    AircraftResponseDTO toDto(Aircraft aircraft);
}
