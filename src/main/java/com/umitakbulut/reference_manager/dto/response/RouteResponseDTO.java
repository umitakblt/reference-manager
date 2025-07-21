package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3152906865355147023L;

    private Long id;
    private String originStationCode;
    private String destinationStationCode;
    private int distance;
}
