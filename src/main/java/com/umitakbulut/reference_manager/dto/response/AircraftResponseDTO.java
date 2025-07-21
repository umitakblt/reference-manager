package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AircraftResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8755534377811334690L;

    private Long id;
    private String registrationNumber;
    private String model;
    private Integer capacity;
}
