package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StationResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4100127586593048862L;

    private Long id;
    private String code;
    private String name;
    private String city;
    private String country;
}
