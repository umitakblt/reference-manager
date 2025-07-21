package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -1561315077094762580L;

    private Long originStationId;
    private Long destinationStationId;
    private int distance;
}
