package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponseDTO {
    private Long id;
    private String originStationCode;
    private String destinationStationCode;
}
