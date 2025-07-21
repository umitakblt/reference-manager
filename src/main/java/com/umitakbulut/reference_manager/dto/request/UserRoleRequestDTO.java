package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8550322568662142382L;

    private Long userId;
    private String role;
}
