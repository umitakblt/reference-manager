package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StationResponseDTO {
    private Long id;
    private String code;
    private String name;
}
