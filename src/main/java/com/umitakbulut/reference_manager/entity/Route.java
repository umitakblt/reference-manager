package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "route")
@Getter
@Setter
@ToString(exclude = {"originStation", "destinationStation"})
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_station_id", nullable = false)
    private Station originStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id", nullable = false)
    private Station destinationStation;

    private Double distance;
}
