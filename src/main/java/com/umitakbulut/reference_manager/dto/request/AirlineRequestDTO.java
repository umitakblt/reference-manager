package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AirlineRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5984523228010189076L;

    private String code;
    private String name;
    private String country;
}
