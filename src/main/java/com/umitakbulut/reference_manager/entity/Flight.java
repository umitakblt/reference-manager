package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Getter
@Setter
@ToString(exclude = {"airline", "aircraft", "originStation", "destinationStation", "flightType"})
@NoArgsConstructor
@AllArgsConstructor
public class Flight implements Serializable {

    @Serial
    private static final long serialVersionUID = -6360679211095651595L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String flightNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_station_id", nullable = false)
    private Station originStation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_station_id", nullable = false)
    private Station destinationStation;

    @Column(nullable = false)
    private LocalDateTime scheduledDeparture;

    @Column(nullable = false)
    private LocalDateTime scheduledArrival;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_type_id", nullable = false)
    private FlightType flightType;
}
