package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AirlineResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7778917474988932170L;

    private Long id;
    private String code;
    private String name;
    private String country;
}
