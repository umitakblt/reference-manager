package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "station")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Station implements Serializable {

    @Serial
    private static final long serialVersionUID = -525872126807005640L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;
}
