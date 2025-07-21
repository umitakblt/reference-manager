package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6197696891469029635L;

    private Long id;
    private String username;
    private String password;
    private String email;
}
