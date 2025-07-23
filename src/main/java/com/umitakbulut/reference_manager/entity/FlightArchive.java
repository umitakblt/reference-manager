package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_archive")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightArchive implements Serializable {

    @Serial
    private static final long serialVersionUID = 8438439438L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;

    private String airlineName;

    private String aircraftModel;

    private String originStationCode;

    private String destinationStationCode;

    private LocalDateTime scheduledDeparture;

    private LocalDateTime scheduledArrival;

    private String flightTypeName;

}
