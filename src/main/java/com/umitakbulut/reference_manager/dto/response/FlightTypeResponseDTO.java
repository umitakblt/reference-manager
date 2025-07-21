package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightTypeResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1146717534350081605L;

    private Long id;
    private String name;
    private String description;
}