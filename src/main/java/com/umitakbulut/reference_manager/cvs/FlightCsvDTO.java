package com.umitakbulut.reference_manager.cvs;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FlightCsvDTO {


    private String flightNumber;

    private Long aircraftId;

    private Long airlineId;

    private Long originStationId;

    private Long destinationStationId;

    private Long flightTypeId;

    private LocalDateTime scheduledDeparture;

    private LocalDateTime scheduledArrival;
}
