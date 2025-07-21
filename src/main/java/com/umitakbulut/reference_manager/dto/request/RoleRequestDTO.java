package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8626561518558714174L;

    private String name;
    private String description;
}