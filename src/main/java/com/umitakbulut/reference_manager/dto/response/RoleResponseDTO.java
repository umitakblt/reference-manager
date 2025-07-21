package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6631627357676327933L;

    private Long id;
    private String name;
    private String description;
}
