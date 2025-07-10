package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequestDTO {
    private String flightNumber;
    private Long airlineId;
    private Long aircraftId;
    private Long originStationId;
    private Long destinationStationId;
    private LocalDateTime scheduledDeparture;
    private LocalDateTime scheduledArrival;
    private Long flightTypeId;
}
