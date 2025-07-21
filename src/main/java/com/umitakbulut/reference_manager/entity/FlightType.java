package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "flight_type")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightType implements Serializable {

    @Serial
    private static final long serialVersionUID = -6361670674103952158L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

}
