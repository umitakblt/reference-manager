package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.FlightRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightResponseDTO;
import com.umitakbulut.reference_manager.entity.Flight;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlightMapperTest {

    private final FlightMapper flightMapper = Mappers.getMapper(FlightMapper.class);

    @Test
    void shouldMapRequestDtoToEntity() {
        FlightRequestDTO requestDTO = new FlightRequestDTO();
        requestDTO.setFlightNumber("TK123");
        requestDTO.setScheduledDeparture(null);

        Flight entity = flightMapper.toEntity(requestDTO);

        assertEquals("TK123", entity.getFlightNumber());
        assertNull(entity.getScheduledDeparture());
    }

    @Test
    void shouldMapEntityToResponseDto() {
        Flight entity = new Flight();
        entity.setFlightNumber("TK123");

        FlightResponseDTO dto = flightMapper.toDto(entity);

        assertEquals("TK123", dto.getFlightNumber());
    }
}
