package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.RouteRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RouteResponseDTO;
import com.umitakbulut.reference_manager.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    @Mapping(source = "originStationId", target = "originStation.id")
    @Mapping(source = "destinationStationId", target = "destinationStation.id")
    Route toEntity(RouteRequestDTO dto);

    @Mapping(source = "originStation.code", target = "originStationCode")
    @Mapping(source = "destinationStation.code", target = "destinationStationCode")
    RouteResponseDTO toResponseDto(Route route);
}