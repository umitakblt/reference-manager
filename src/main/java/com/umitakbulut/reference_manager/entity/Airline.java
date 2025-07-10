package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "airline")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private String country;
}
