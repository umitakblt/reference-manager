package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.FlightTypeRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightTypeResponseDTO;
import com.umitakbulut.reference_manager.entity.FlightType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightTypeMapper {

    FlightType toEntity(FlightTypeRequestDTO requestDTO);

    FlightTypeResponseDTO toResponseDTO(FlightType entity);

}
