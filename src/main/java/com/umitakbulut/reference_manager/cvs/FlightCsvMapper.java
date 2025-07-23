package com.umitakbulut.reference_manager.cvs;

import com.umitakbulut.reference_manager.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlightCsvMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "flightNumber", source = "flightNumber")
    @Mapping(target = "aircraft.id", source = "aircraftId")
    @Mapping(target = "airline.id", source = "airlineId")
    @Mapping(target = "originStation.id", source = "originStationId")
    @Mapping(target = "destinationStation.id", source = "destinationStationId")
    @Mapping(target = "flightType.id", source = "flightTypeId")
    Flight fromCsvDto(FlightCsvDTO dto);
}
