package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "airline")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Airline implements Serializable {

    @Serial
    private static final long serialVersionUID = -2690324655303307226L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code" , nullable = false, unique = true, length = 4)
    private String code;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "country" , nullable = false)
    private String country;
}
