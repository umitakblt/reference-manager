package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StationRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3257820436453405836L;

    private String code;
    private String name;
    private String city;
    private String country;
}
