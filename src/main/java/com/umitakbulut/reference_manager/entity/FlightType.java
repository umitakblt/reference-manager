package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flight_type")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

}
