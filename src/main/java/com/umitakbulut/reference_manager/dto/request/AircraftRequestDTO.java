package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AircraftRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4688869051414890953L;

    private String registrationNumber;
    private String model;
    private Integer capacity;
}
