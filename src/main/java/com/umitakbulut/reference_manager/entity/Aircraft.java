package com.umitakbulut.reference_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "aircraft")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft implements Serializable {

    @Serial
    private static final long serialVersionUID = -8804893560302442065L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

}