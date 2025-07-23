package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.response.FlightResponseDTO;
import com.umitakbulut.reference_manager.entity.Flight;
import com.umitakbulut.reference_manager.entity.FlightArchive;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightArchiveMapper {
    FlightArchive fromFlight(Flight flight);

    FlightResponseDTO toDto(FlightArchive flightArchive);
    FlightArchive toEntity(FlightResponseDTO dto);

}
