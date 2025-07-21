package com.umitakbulut.reference_manager.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4687001846283212804L;

    private String username;
    private String email;
    private String password;
}
