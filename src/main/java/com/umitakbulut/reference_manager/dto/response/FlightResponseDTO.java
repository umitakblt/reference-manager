package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7194295688766988659L;

    private Long id;
    private String flightNumber;
    private String airlineId;
    private String aircraftId;
    private String originStationId;
    private String destinationStationId;
    private LocalDateTime scheduledDeparture;
    private LocalDateTime scheduledArrival;
    private String flightTypeId;
}
