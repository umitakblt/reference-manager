package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightTypeRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 9112854854502655030L;

    private String name;
    private String description;
}
